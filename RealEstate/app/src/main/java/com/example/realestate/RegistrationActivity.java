package com.example.realestate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegistrationActivity extends AppCompatActivity {
    private EditText regUsername,regEmail,regPassword;
    private Button regSignup;
    private TextView regLogin;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        regUsername=(EditText) findViewById(R.id.reg_username);
        regEmail=(EditText) findViewById(R.id.reg_email);
        regPassword=(EditText) findViewById(R.id.reg_password);
        regSignup=(Button) findViewById(R.id.reg_signup);
        regLogin=(TextView) findViewById(R.id.reg_login);

        firebaseAuth=FirebaseAuth.getInstance();

        regSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate()){
                    String user_email=regEmail.getText().toString().trim();
                    String user_pass=regPassword.getText().toString().trim();

                    firebaseAuth.createUserWithEmailAndPassword(user_email, user_pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(RegistrationActivity.this,"Registration Successfull",Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(RegistrationActivity.this,MainActivity.class));
                            }
                            else{
                                Toast.makeText(RegistrationActivity.this,"Registration Failed",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

        regLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegistrationActivity.this,MainActivity.class));
            }
        });

    }

    private void setupUIViews(){

    }

    private boolean validate(){
        boolean result = false;

        String str_username = regUsername.getText().toString();
        String str_email = regEmail.getText().toString();
        String str_pass = regPassword.getText().toString();

        if(str_username.isEmpty() || str_email.isEmpty() || str_pass.isEmpty()){
            Toast.makeText(RegistrationActivity.this,"Please Enter all the details",Toast.LENGTH_LONG).show();
        }
        else{
            result = true;
        }
        return result;
    }
}
