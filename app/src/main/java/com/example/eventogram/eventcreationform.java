package com.example.eventogram;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class eventcreationform extends AppCompatActivity {

    Button regbtn;
    EditText fullname,description,Imageurl,Organizername,Timing,Date;

    boolean valid = true;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    FirebaseFirestore firebaseFirestore;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventregistrationform);

        fullname = findViewById(R.id.FullName);
        description = findViewById(R.id.Description);
        Imageurl = findViewById(R.id.imageurl);
        Organizername = findViewById(R.id.organizername);
        Timing = findViewById(R.id.timimg);
        Date = findViewById(R.id.date);
        regbtn = findViewById(R.id.btnRegister);
        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();


//        Calendar calendar = Calendar.getInstance();
//        int yearcal = calendar.get(Calendar.YEAR);
//        int month = calendar.get(Calendar.MONTH);
//        int day = calendar.get(Calendar.DAY_OF_MONTH);

        regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkField(fullname);
                checkField(description);
                checkField(Imageurl);
                checkField(Organizername);
                checkField(Timing);
                checkField(Date);

                if(valid){
                    FirebaseUser user = fAuth.getCurrentUser();
                    DocumentReference df = firebaseFirestore.collection("Registered Events").document(user.getUid());

                    Toast.makeText(eventcreationform.this, "Event organized", Toast.LENGTH_SHORT).show();
              //      Toast.makeText(eventregistrationform.this, "Registered event", Toast.LENGTH_SHORT).show();
                    Map<String,Object> userInfo = new HashMap<>();
                    userInfo.put("Name",fullname.getText().toString());
                    userInfo.put("Description",description.getText().toString());
                    userInfo.put("Imageurl",Imageurl.getText().toString());
                    userInfo.put("Organizer name",Organizername.getText().toString());
                    userInfo.put("Timimg",Timing.getText().toString());
                    userInfo.put("Date",Date.getText().toString());
                    df.set(userInfo);

                    startActivity(new Intent(getApplicationContext(),Admin.class));
                    finish();

                }else{
                    Toast.makeText(eventcreationform.this, "Some error occured", Toast.LENGTH_SHORT).show();
                 //   Toast.makeText(eventregistrationform.this, "Error", Toast.LENGTH_SHORT).show();
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