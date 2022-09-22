package com.example.eventogram;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Editable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class RegisterActivity extends AppCompatActivity {

    EditText name,Email,password,number;
    Button RegisterButton;
    DatabaseReference studentDBRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name = findViewById(R.id.editTextName);
        Email = findViewById(R.id.editTextEmail);
        number = findViewById(R.id.editTextMobile);
        password = findViewById(R.id.editTextPassword);
        RegisterButton = findViewById(R.id.RegisterButton);

        studentDBRef = FirebaseDatabase.getInstance().getReference().child("Members");
        RegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertMemberData();
            }
        });


    }
    public void onLoginClick(View view){
        startActivity(new Intent(this,LoginActivity.class));
        overridePendingTransition(R.anim.slide_in_left,android.R.anim.slide_out_right);


    }
    public void insertMemberData(){

        String Name = name.getText().toString();
        String email = Email.getText().toString();
        String Password = password.getText().toString();
        String phone = number.getText().toString();


        Member member = new Member(Name,email,phone,Password);

        studentDBRef.push().setValue(member);
        Toast.makeText(this, "Data is inserted", Toast.LENGTH_SHORT).show();
    }



    
}