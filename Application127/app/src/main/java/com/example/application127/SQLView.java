package com.example.application127;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SQLView extends AppCompatActivity {
    TextView tvresult;
    SQL db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql_view);

        tvresult=(TextView) findViewById(R.id.tv_result);
        String data=db.getData();
        tvresult.setText(data);
    }
}
