package com.example.projectandroid;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.core.content.FileProvider;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Environment;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.projectandroid.ui.main.SectionsPagerAdapter;
import com.example.projectandroid.databinding.ActivityDetailInterventionBinding;

import org.w3c.dom.Text;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class detailIntervention extends AppCompatActivity {
    private static final int RETOUR_PRENDRE_PHOTO=1;
    private ActivityDetailInterventionBinding binding;
    private ImageView imageViewaffiche;
    private String photoPath=null;
    TextView TextViewTitle,TextViewSociete,TextViewTime,TextViewHours;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDetailInterventionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);
        //FloatingActionButton fab = binding.fab;
        String titreIntervention=getIntent().getStringExtra("Title");
        String SocieteIntervention=getIntent().getStringExtra("Societe");
        String TempIntervention=getIntent().getStringExtra("Time");
        TextViewTitle=findViewById(R.id.textViewTitle);
        TextViewSociete=findViewById(R.id.textViewSociete);
        TextViewTime=findViewById(R.id.textViewTime);
        TextViewTitle.setText(titreIntervention);
        TextViewSociete.setText(SocieteIntervention);
        TextViewTime.setText(TempIntervention);

        /*fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    public void goMap(View view) {
        // Create a Uri from an intent string. Use the result to create an Intent.
        Uri gmmIntentUri = Uri.parse("geo:37.827500,-122.481670");

        // Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        // Make the Intent explicit by setting the Google Maps package
        mapIntent.setPackage("com.google.android.apps.maps");


        // Attempt to start an activity that can handle the Intent
        startActivity(mapIntent);
    }

    public void goHistorique(View view) {
        Intent intent=new Intent(detailIntervention.this,HistoriqueActivity.class);
        startActivity(intent);

    }

    public void capture(View view) {
    }

   /* public void prendrePhoto(View view) throws IOException {
        imageViewaffiche=findViewById(R.id.imageafficherimage);
        prendreUnePhoto();

    }
    //acces a l'appareil photo et mémoriser dans un fichier
    private  void prendreUnePhoto() {
        //creer une intent pour prendre photo
        Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //test pour controler que l'intent peut etre géré
        if (intent.resolveActivity(getPackageManager())!=null){
            //créer un nom de fichier unique
            String time=new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            File photoDir=getExternalFilesDir(Environment.DIRECTORY_PICTURES);
            File photoFile= null;
            try {
                photoFile = File.createTempFile("photo"+time,".jpg",photoDir);
                //enrigesterr le chemin complet
                photoPath=photoFile.getAbsolutePath();
                //creer l'uri (code specifique ermet acces au fichier)
                Uri photoUri= FileProvider.getUriForFile(detailIntervention.this,
                        detailIntervention.this.getApplicationContext().getPackageName()+".provider",photoFile);
                //transfert uri vers l'intent pour enregistrer photo dans fichier temporaire
                intent.putExtra(MediaStore.EXTRA_OUTPUT,photoUri);
                //ouvrir activité p/p a intetnt
                startActivityForResult(intent,RETOUR_PRENDRE_PHOTO);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    /**
     * retour de l'appel de l'appareil photo
     * @param requestCode
     * @param resultCode
     * @param data
     */
    /*@Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data) {
        super.onActivityResult(requestCode,resultCode,data);
        //verifie le bon code de retour et l'etat de retour ok
        if(requestCode==RETOUR_PRENDRE_PHOTO && resultCode==RESULT_OK){
            //recuperer l'image
            Bitmap image= BitmapFactory.decodeFile(photoPath);
            //afficher image
            imageViewaffiche.setImageBitmap(image);
        }*/

}