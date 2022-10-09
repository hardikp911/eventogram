package com.example.eventogram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class eventregistrationform extends AppCompatActivity {

    Button regbtn;
    EditText fullname,number,year,department,email;
    boolean valid = true;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    FirebaseFirestore firebaseFirestore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventregistrationform);

        fullname = findViewById(R.id.FullName);
        email = findViewById(R.id.Email);
        department = findViewById(R.id.department);
        year = findViewById(R.id.year);
        number = findViewById(R.id.phonenumber);

        regbtn = findViewById(R.id.btnRegister);
        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();


        regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkField(fullname);
                checkField(email);
                checkField(department);
                checkField(year);
                checkField(number);

                if(valid){
                    FirebaseUser user = fAuth.getCurrentUser();
                    DocumentReference df = firebaseFirestore.collection("RegisterEvents").document(user.getUid());

                    Toast.makeText(eventregistrationform.this, "Registered event", Toast.LENGTH_SHORT).show();
                    Map<String,Object> userInfo = new HashMap<>();
                    userInfo.put("Name",fullname.getText().toString());
                    userInfo.put("Email",email.getText().toString());
                    userInfo.put("Department",department.getText().toString());
                    userInfo.put("Year",year.getText().toString());
                    userInfo.put("Mobile Number",number.getText().toString());
                    df.set(userInfo);

                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    finish();

                }else{
                    Toast.makeText(eventregistrationform.this, "Error", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
    public boolean checkField(EditText textField){
        if(textField.getText().toString().isEmpty()){
            textField.setError("Error");
            valid = false;
        }else {
            valid = true;
        }

        return valid;
    }
}