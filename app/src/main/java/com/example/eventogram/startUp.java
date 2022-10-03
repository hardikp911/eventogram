package com.example.eventogram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

public class startUp extends AppCompatActivity {

    ImageView imageView;
    AnimationDrawable animationDrawable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_up);
//        getSupportActionBar().hide();
        imageView = findViewById(R.id.imageView);
        imageView.setBackgroundResource(R.drawable.startupimage);
        animationDrawable = (AnimationDrawable) imageView.getBackground();

        // now start animation as well as activity started....

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
                finish();
            }
        },3000);



    }

    @Override
    protected void onStart() {
        super.onStart();
        animationDrawable.start();
    }
}