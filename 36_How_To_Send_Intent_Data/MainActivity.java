package com.example.application36;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void firstButtonClick(View view){
        Intent intent = new Intent(this, Main2Activity.class) ;
        final EditText firstInput = (EditText) findViewById(R.id.editText);
        String usermessage = firstInput.getText().toString();
        intent.putExtra("firstMessage", usermessage);
        startActivity(intent);
    }
}
