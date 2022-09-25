package com.example.eventogram;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import org.w3c.dom.Document;

import java.util.HashMap;
import java.util.Map;


public class LoginActivity extends AppCompatActivity {


    Button loginbutton;
    EditText Email,password;
    boolean valid = true;
    FirebaseAuth firebaseAuth;
    FirebaseFirestore firebaseFirestore;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        loginbutton = findViewById(R.id.cirLoginButton);
        Email = findViewById(R.id.editTextEmail);
        password = findViewById(R.id.editTextPassword);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();

        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkField(Email);
                checkField(password);

                if(valid){
                    //user login
                    firebaseAuth.createUserWithEmailAndPassword(Email.getText().toString(),password.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            Toast.makeText(LoginActivity.this, "Logged in SuccessFully ", Toast.LENGTH_SHORT).show();
                            checkUserAccessLevel(authResult.getUser().getUid());
//                            startActivity(new Intent(getApplicationContext(), userDashboard.class));
//                            finish();



                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    });

                }


            }
        });

        if(firebaseAuth.getCurrentUser()!=null){
            startActivity(new Intent(getApplicationContext(), userDashboard.class));
            finish();

        }

//        loginbutton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String email = Email.getText().toString().trim();
//                String Password = password.getText().toString().trim();
//                if(TextUtils.isEmpty(email))
//                {
//                    Email.setError("Email is Required....");
//                    return;
//                }
//                if(TextUtils.isEmpty(Password))
//                {
//                    password.setError("Password is Required....");
//                    return;
//                }
//                if(Password.length() < 6)
//                {
//                    password.setError("Password should be more than 6 characters");
//
//                }
//
//                // authenticate user
//
//                firebaseAuth.signInWithEmailAndPassword(email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//
//
//
//                        if(task.isSuccessful()) {
//
//                            Toast.makeText(LoginActivity.this, "Logged in", Toast.LENGTH_SHORT).show();
//                            checkIfAdmin(email,getTaskId());
////                            startActivity(new Intent(getApplicationContext(), userDashboard.class));
////                            finish();
//                        }else
//                        {
//                            Toast.makeText(LoginActivity.this, "Error"+task.getException().getMessage(), Toast.LENGTH_LONG).show();
//
//                        }
//
//                    }
//                });
//
//            }
//        });
// to check already login or not
//protected void onStart(){
//    super.onStart();
//    if(FirebaseAuth.getInstance().getCurrentUser()!=null){
//        startActivity(new Intent(getApplicationContext(), userDashboard.class));
//        finish();
//    }
//        }


//
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(LoginActivity.this,userDashboard.class);
//                startActivity(intent);
//            }
//        });

    }

    private void checkUserAccessLevel(String uid) {

        DocumentReference df = firebaseFirestore.collection("users").document(uid);
        //extract data
        df.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                Log.d("TAG", "onSuccess: "+documentSnapshot.getData());
               // identify the user access level
                if(documentSnapshot.getString("isTeacher")!= null)
                {
                   // user is admin
                    startActivity(new Intent(getApplicationContext(),Admin_dashboard.class));
                    finish();


                }
                if(documentSnapshot.getString("isStudent")!= null)
//                else
                {
                    // user is admin
                    startActivity(new Intent(getApplicationContext(),userDashboard.class));
                    finish();


                }


            }
        });

    }


//    @Override
//    protected void onStart() {
//        super.onStart();
//        startActivity(new Intent(getApplicationContext(),Admin_dashboard.class));
//        finish();

//        if(FirebaseAuth.getInstance().getCurrentUser()!=null)
//        {
//            DocumentReference df = FirebaseFirestore.getInstance().collection("users").document(FirebaseAuth.getInstance().getCurrentUser().getUid());
//            df.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                @Override
//                public void onSuccess(DocumentSnapshot documentSnapshot) {
//
////                    if(documentSnapshot.getString("isUser"!= null)){
////                        startActivity(new Intent(getApplicationContext(),userDashboard.class));
////                        finish();
////                    }
////                    if(documentSnapshot.getString("isAdmin" != null)){
////                        startActivity(new Intent(getApplicationContext(),Admin_dashboard.class));
////                        finish();
////                    }
//                    startActivity(new Intent(getApplicationContext(),Admin_dashboard.class));
//                        finish();
//
//                }
//            }).addOnFailureListener(new OnFailureListener() {
//                @Override
//                public void onFailure(@NonNull Exception e) {
//
//                    FirebaseAuth.getInstance().signOut();
//                    startActivity(new Intent(getApplicationContext(),LoginActivity.class));
//                    finish();
//                }
//            });
//        }
//    }

    private boolean checkField(EditText textField) {
        if(textField.getText().toString().isEmpty()){
            textField.setError("Error");
            valid = false;
        }else {
            valid = true;
        }

        return valid;

    }



    public void onLoginClick(View View){
        startActivity(new Intent(this,RegisterActivity.class));
        overridePendingTransition(R.anim.slide_in_right,R.anim.stay);

    }
}





