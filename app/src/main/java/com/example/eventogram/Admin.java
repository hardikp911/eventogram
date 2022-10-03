package com.example.eventogram;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;

import com.example.eventogram.admin.Event_CreateForm;
import com.google.firebase.auth.FirebaseAuth;

public class Admin extends AppCompatActivity {

//    CardView createEvent ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

//        createEvent = findViewById(R.id.createEvent);
//
//        createEvent.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent intent = new Intent(getApplicationContext(),Event_CreateForm.class);
//                startActivity(intent);
//
//            }
//        });
    }




}