package com.example.eventogram;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import org.w3c.dom.Document;

import java.util.HashMap;
import java.util.Map;


public class RegisterActivity extends AppCompatActivity {

    EditText fullName,Email,password,Phone;
    Button RegisterButton;
    boolean valid = true;
    FirebaseAuth firebaseAuth;
    FirebaseFirestore firebaseFirestore;
    RadioButton isTeacher, isStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        fullName = findViewById(R.id.editTextName);
        Email = findViewById(R.id.editTextEmail);
        Phone = findViewById(R.id.editTextMobile);
        password = findViewById(R.id.editTextPassword);
        RegisterButton = findViewById(R.id.RegisterButton);
        isStudent =findViewById(R.id.isStudent);
        isTeacher= findViewById(R.id.isTeacher);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();

        //check box logic
//        isStudent.setOnClickListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                if(compoundButton.isChecked()) isTeacher.setChecked(false);
//            }
//        });
//        isTeacher.setOnClickListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                if(compoundButton.isChecked()){
//                    isStudent.setChecked(false);
//                }
//            }
//        });

        RegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



        checkField(fullName);

        checkField(Email);
        checkField(Phone);
        checkField(password);

        //checkbox validation


                if(!(isStudent.isChecked() || isTeacher.isChecked())){
                    Toast.makeText(RegisterActivity.this, "Select the account type...", Toast.LENGTH_SHORT).show();
                    return;
                }


        if(valid){
            //start user registration
            firebaseAuth.createUserWithEmailAndPassword(Email.getText().toString(),password.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
                    FirebaseUser user = firebaseAuth.getCurrentUser();

                    Toast.makeText(RegisterActivity.this, "user Created ", Toast.LENGTH_SHORT).show();
                    DocumentReference df = firebaseFirestore.collection("users").document(user.getUid());
                       Map<String,Object> userInfo = new HashMap<>();
                        userInfo.put("Fullname",fullName.getText().toString());
                        userInfo.put("Email",Email.getText().toString());
                        userInfo.put("Phone",Phone.getText().toString());
                        userInfo.put("Password",password.getText().toString());
                        // specify if the user is admin or not
                            if(isTeacher.isChecked())
                            {
                                userInfo.put("isAdmin","1");

                            }
                    if(isStudent.isChecked())
                    {
                                userInfo.put("isUser","1");

                            }
//                        df.set(userInfo).addOnSuccessListener(new OnSuccessListener<Void>() {
//                            @Override
//                            public void onSuccess(Void unused) {
//                                Toast.makeText(RegisterActivity.this, "account created perfectly", Toast.LENGTH_LONG).show();
//                            }
//                        });
//                        startActivity(new Intent(getApplicationContext(), userDashboard.class));
//                        finish();
                    df.set(userInfo);
                    if(isTeacher.isChecked()){
                         startActivity(new Intent(getApplicationContext(), Admin_dashboard.class));
                         finish();
                    }
                    if(isStudent.isChecked()){
                        startActivity(new Intent(getApplicationContext(), userDashboard.class));
                        finish();
                    }


                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(RegisterActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });

        }
            }
        });

//        if(firebaseAuth.getCurrentUser()!=null){
//            startActivity(new Intent(getApplicationContext(), userDashboard.class));
//            finish();
//
//        }

//        RegisterButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                String email = Email.getText().toString().trim();
//                String Password = password.getText().toString().trim();
//                String username = name.getText().toString().trim();
//                String PhoneNumber = number.getText().toString().trim();
//
//
//                if(TextUtils.isEmpty(email))
//                {
//                    Email.setError("Email is Required....");
//                    return;
//                }
//                if(TextUtils.isEmpty(username))
//                {
//                    name.setError("username  is Required....");
//                    return;
//                }
//                if(TextUtils.isEmpty(PhoneNumber))
//                {
//                    number.setError("Phone number is Required....");
//                    return;
//                }
//
//                if(TextUtils.isEmpty(Password))
//                {
//                    password.setError("Password is Required....");
//                    return;
//                }
//                if(Password.length() < 6)
//                {
//                        password.setError("Password should be more than 6 characters");
//
//                }
//
//                // register the user
//                firebaseAuth.createUserWithEmailAndPassword(email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//
//                    if(task.isSuccessful()) {
//                        FirebaseUser user = firebaseAuth.getCurrentUser();
//                        Toast.makeText(RegisterActivity.this, "user Created ", Toast.LENGTH_SHORT).show();
//                        DocumentReference df = firebaseFirestore.collection("user").document(user.getUid());
//                        Map<String,Object> userInfo = new HashMap<>();
//                        userInfo.put("Fullname",name.getText().toString());
//                        userInfo.put("Email",Email.getText().toString());
//                        userInfo.put("Phone",number.getText().toString());
//                        userInfo.put("Password",password.getText().toString());
//                        // specify if the user is admin
//                        userInfo.put("isUser","1");
//
//                        df.set(userInfo);
//
//
//
//                        startActivity(new Intent(getApplicationContext(), userDashboard.class));
//                        finish();
//                    }else
//                    {
//                        Toast.makeText(RegisterActivity.this, "Error"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
//
//                    }
//
//                    }
//                });
//
//            }
//        });


//        checkField(name);
//        studentDBRef = FirebaseDatabase.getInstance().getReference().child("Members");
//        RegisterButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                insertMemberData();
//
//            }
//        });




    }

    private boolean checkField(EditText textField) {
        if(textField.getText().toString().isEmpty()){
            textField.setError("Error");
            valid = false;
        }else {
            valid = true;
        }

        return valid;

    }

    public void onLoginClick(View view){
        startActivity(new Intent(this,LoginActivity.class));
        overridePendingTransition(R.anim.slide_in_left,android.R.anim.slide_out_right);


    }
//    public void insertMemberData(){
//
//        String Name = name.getText().toString();
//        String email = Email.getText().toString();
//        String Password = password.getText().toString();
//        String phone = number.getText().toString();
//
//
//        Member member = new Member(Name,email,phone,Password);
//
//        studentDBRef.push().setValue(member);
//        Toast.makeText(this, "Data is inserted", Toast.LENGTH_SHORT).show();
//    }



    
}