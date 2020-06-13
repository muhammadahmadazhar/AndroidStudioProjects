package com.example.realestate;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText mainEmail;
    private EditText mainPass;
    private CardView mainLogin;

    private TextView mySignup;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mainEmail=(EditText) findViewById(R.id.myemail);
        mainPass=(EditText) findViewById(R.id.mypass);
        mainLogin=(CardView) findViewById(R.id.cardView);

        firebaseAuth=FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);

        FirebaseUser user=firebaseAuth.getCurrentUser();
        if(user != null){
            finish();//this function destroy activity
            startActivity(new Intent(this,HomeActivity.class));
        }

        mainLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(mainEmail.getText().toString(),mainPass.getText().toString());
            }
        });

        mySignup=(TextView) findViewById(R.id.my_signup);
        mySignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,RegistrationActivity.class));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClickContinue(View view) {
        EditText et1=(EditText) findViewById(R.id.myemail);
        EditText et2=(EditText) findViewById(R.id.mypass);
        String email=et1.getText().toString();
        String pass=et2.getText().toString();
        String originalemail="admin";
        String originalpass="admin";

        if(email.equals(originalemail) && pass.equals(originalpass)){
            Toast toast=Toast.makeText(this,"Login",Toast.LENGTH_LONG);
            toast.show();
        }
        else {
            Toast toast=Toast.makeText(this,"INVALID EMAIL/PASSWORD",Toast.LENGTH_LONG);
            toast.show();
        }

    }

    private void validate(String strUsername,String strPassword){
        progressDialog.setMessage("Loading in Progress");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(strUsername,strPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    progressDialog.dismiss();
                    Toast.makeText(MainActivity.this,"Login Successfull",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this,HomeActivity.class));
                }
                else{
                    progressDialog.dismiss();
                    Toast.makeText(MainActivity.this,"Login failed",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}
