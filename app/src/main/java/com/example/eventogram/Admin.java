package com.example.eventogram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
//import android.view.View;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.Toast;

public class Admin extends AppCompatActivity {

   CardView createEvent ;
   GridLayout mainGrid1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

//        createEvent =  findViewById(R.id.createEvent);
//
//        createEvent.setOnClickListener(v -> {
        mainGrid1 = findViewById(R.id.mainGrid1);
        setSingleEvent(mainGrid1);

//            Intent intent = new Intent(Admin.this,Event_CreateForm.class);
//            startActivity(intent);

    }

    private void setSingleEvent(GridLayout mainGrid1) {
        for(int i=0;i<mainGrid1.getChildCount();i++) {
            CardView cardView = (CardView) mainGrid1.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (finalI == 0) {
                        Intent intent = new Intent(getApplicationContext(), eventcreationform.class);
                        startActivity(intent);

                    } else if (finalI == 1) {
                        Intent intent = new Intent(getApplicationContext(), Login.class);
                        startActivity(intent);
                    } else if (finalI == 2) {
                        Intent intent = new Intent(getApplicationContext(), Login.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(Admin.this, "Sorry", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }


    }
    }




