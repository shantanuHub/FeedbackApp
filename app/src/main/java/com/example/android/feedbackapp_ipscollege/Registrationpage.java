package com.example.android.feedbackapp_ipscollege;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Registrationpage extends AppCompatActivity {

    EditText email , pass ;
    Button register;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrationpage);
        mAuth = FirebaseAuth.getInstance();

        email = findViewById(R.id.email);
        pass = findViewById(R.id.pass);
        register = findViewById(R.id.regBtn);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Myemail = email.getText().toString();
                String Mypass = pass.getText().toString();

                mAuth.createUserWithEmailAndPassword(Myemail , Mypass )
                        .addOnCompleteListener(Registrationpage.this  ,new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful())
                                {
                                    FirebaseUser user  = mAuth.getCurrentUser();
                                    Toast.makeText(Registrationpage.this , "Registration Done" , Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(Registrationpage.this , MainActivity.class));
                                    finish();
                                }else
                                {
                                    Toast.makeText(Registrationpage.this , "Registration Failed" , Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }
}
