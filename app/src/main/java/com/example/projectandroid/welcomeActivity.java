package com.example.projectandroid;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class welcomeActivity extends AppCompatActivity {
    Animation topAnimation,bottonAnimation;
    ImageView image;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //animation
        topAnimation= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottonAnimation= AnimationUtils.loadAnimation(this,R.anim.botton_animation);
        //hooks
        image=findViewById(R.id.imagelogo);
        text=findViewById(R.id.textViewlogo);
        image.setAnimation(topAnimation);
        text.setAnimation(bottonAnimation);
        //rederiger vers page log in apres 3 s
        Runnable runnable = new Runnable() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void run() {
                //demmarer une page
                SharedPreferences sharedPreferences = getSharedPreferences("userinformations", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                Boolean isconnected = sharedPreferences.getBoolean("isconnected", false);
                if (isconnected) {
                    Intent intent = new Intent(getApplicationContext(),interventions.class);
                    startActivity(intent);
                    finish();
                } else {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    Pair[] pairs=new Pair[2];
                    pairs[0]=new Pair<View,String>(image,"logo_image");
                    pairs[1]=new Pair<View,String>(image,"logo_name");
                    ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(welcomeActivity.this, pairs);
                    startActivity(intent,options.toBundle());
                    finish();
                }
            }
        };
        //handler post delayed
        new Handler().postDelayed(runnable,3000);
    }
}