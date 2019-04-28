package com.example.android.feedbackapp_ipscollege;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    Button login , signin ;
    EditText email , pass ;
    FirebaseAuth mAuth;

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentuser = mAuth.getCurrentUser();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();

        login = findViewById(R.id.button);
        signin = findViewById(R.id.button2);
        email = findViewById(R.id.email);
        pass = findViewById(R.id.pass);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Myemail = email.getText().toString();
                String Mypass = pass.getText().toString();

                mAuth.signInWithEmailAndPassword(


                        Myemail , Mypass )
                        .addOnCompleteListener(MainActivity.this ,new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful())
                                {
                                    Log.d("test", "createUserWithEmail:success");
                                    FirebaseUser user  = mAuth.getCurrentUser();
                                    Toast.makeText(MainActivity.this , "Registration successful" , Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(MainActivity.this , Mainpage.class));
                                }else
                                {
                                    Log.w("test", "createUserWithEmail:failure", task.getException());

                                    Toast.makeText(MainActivity.this , "Something went wrong" , Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this , Registrationpage.class));
            }
        });


    }


}

