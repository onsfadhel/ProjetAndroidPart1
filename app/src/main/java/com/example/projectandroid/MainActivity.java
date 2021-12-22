package com.example.projectandroid;
import static com.example.projectandroid.SharedHelper.sha256;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {
    EditText editTextemail,editTextpassword;
    Button loginbutton;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences sharedPreferences = getSharedPreferences("userinformations", Context.MODE_PRIVATE);
        String email = sharedPreferences.getString("email", "email not found");
        String password = sharedPreferences.getString("password", "password not found");
        //declaration du var is connected
        Boolean isconnected = sharedPreferences.getBoolean("isconnected", false);
        editTextemail = findViewById(R.id.editTextEmail);
        editTextpassword = findViewById(R.id.editTextPassword);
        String logemail = editTextemail.getText().toString();
        String logpassword = editTextpassword.getText().toString();
        loginbutton = findViewById(R.id.btnlogin);
        //création de la base de donnée  au ouverture de connexion
        db = openOrCreateDatabase("ComptesWeb", MODE_PRIVATE, null);
        //Création de la table users
        db.execSQL("CREATE TABLE IF NOT EXISTS USERS (login varchar primary Key ,password varchar);");
        //si la table users est vide alors ajouter l'utilisateur admin avec mot de passe "123"
        SQLiteStatement s = db.compileStatement("select count(*) from users ;");
        long c = s.simpleQueryForLong();
        if (c == 0) {
            db.execSQL("insert into users (login,password)values (?,?)", new String[]{"admin", sha256("123")});
        }
        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strlogin = editTextemail.getText().toString();
                String strpwd = editTextpassword.getText().toString();
                bg background=new bg(MainActivity.this);
                background.execute(strlogin,strpwd);

                /**if(strlogin.isEmpty()){
                    Toast.makeText(MainActivity.this,"Veuillez entrer votre login",Toast.LENGTH_LONG).show();

                }
                if(strpwd.isEmpty()){
                    Toast.makeText(MainActivity.this,"Veuillez entrer votre mot de passe",Toast.LENGTH_LONG).show();
                }*/
                //créer un curseur :matrice pour récupérer le résultat de la requete select
                Cursor cursor = db.rawQuery("select password from users where login=?", new String[]{strlogin});
                try {
                    cursor.moveToFirst();
                    String p = cursor.getString(0);
                    if (p.equals(sha256(strpwd))) {
                        Toast.makeText(getApplicationContext(), "Bienvenue" + strlogin, Toast.LENGTH_LONG).show();
                        Intent i = new Intent(getApplicationContext(), interventions.class);
                        startActivity(i);
                    } else {
                        editTextemail.setText("");
                        editTextpassword.setText("");
                        Toast.makeText(getApplicationContext(), "echec de connexion", Toast.LENGTH_LONG).show();
                    }
                } catch (Exception e) {
                    editTextemail.setText("");
                    editTextpassword.setText("");
                    Toast.makeText(getApplicationContext(), "utilisateur inexistant", Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        });

    }
    private class bg extends AsyncTask<String,Void,String> {
        AlertDialog dialog;
        Context c;

        public bg(Context context) {
            this.c = context;

        }

        @Override
        protected void onPreExecute() {
            dialog = new AlertDialog.Builder(c).create();
            dialog.setTitle("Etat de connexion");
        }

        @Override
        protected String doInBackground(String... strings) {
            String result = "";
            String user = strings[0];
            String pass = strings[1];
            String connstr="http://192.168.1.6//application android//loginemployes.php";
            try{
                URL url = new URL(connstr);
                HttpURLConnection http=(HttpURLConnection) url.openConnection();
                http.setRequestMethod("POST");
                http.setDoInput(true);
                http.setDoOutput(true);
                OutputStream ops=http.getOutputStream();
                BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(ops,"UTF-8"));
                String data = URLEncoder.encode("user","UTF-8") + "=" + URLEncoder.encode(user,"UTF-8") +
                        "&&" + URLEncoder.encode("pass", "UTF-8")+ "=" + URLEncoder.encode(pass,"UTF-8");
                writer.write(data);
                writer.flush();
                writer.close();
                InputStream ips = http.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(ips, "ISO-8859-1"));
                String ligne ="";
                while ((ligne = reader.readLine())!= null){
                    result = result + ligne;
                    // ou bien result += ligne;

                }
                reader.close();
                ips.close();
                http.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            dialog.setMessage(s);
            try {
                dialog.show();
            } catch (Exception e){
                Log.e("errorpost",e.getMessage());
            }

            if (s.contains("Vous avez reussi de se loger")){
                Intent i = new Intent();
                i.setClass(c.getApplicationContext(),interventions.class);
                startActivity(i);
            }
        }

    }
}