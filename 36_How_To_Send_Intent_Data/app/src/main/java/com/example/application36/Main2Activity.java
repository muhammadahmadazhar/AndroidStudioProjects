package com.example.application36;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Bundle firstData = getIntent().getExtras();

        if(firstData == null){
            return;
        }
        String firstMessage = firstData.getString("firstMessage");
        final TextView text = (TextView) findViewById(R.id.textView3);
        text.setText(firstMessage);
    }
}
