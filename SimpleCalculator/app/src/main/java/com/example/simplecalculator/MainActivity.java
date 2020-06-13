package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editFirst, editSecond;
    Button add,sub,mul,div;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editFirst = (EditText) findViewById(R.id.edit_first);
        editSecond = (EditText) findViewById(R.id.edit_sec);

        add = (Button) findViewById(R.id.button_add);
        sub = (Button) findViewById(R.id.button_sub);
        mul = (Button) findViewById(R.id.button_mul);
        div = (Button) findViewById(R.id.button_div);

        tvResult = (TextView) findViewById(R.id.tv_result);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int firstValue, secondValue, result;
                firstValue = Integer.valueOf(editFirst.getText().toString());
                secondValue = Integer.valueOf(editSecond.getText().toString());
                result = firstValue + secondValue;
                tvResult.setText("Your result is= "+ result);
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int firstValue, secondValue, result;
                firstValue = Integer.valueOf(editFirst.getText().toString());
                secondValue = Integer.valueOf(editSecond.getText().toString());
                result = firstValue - secondValue;
                tvResult.setText("Your result is= "+ result);
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int firstValue, secondValue, result;
                firstValue = Integer.valueOf(editFirst.getText().toString());
                secondValue = Integer.valueOf(editSecond.getText().toString());
                result = firstValue * secondValue;
                tvResult.setText("Your result is= "+ result);
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int firstValue, secondValue, result;
                firstValue = Integer.valueOf(editFirst.getText().toString());
                secondValue = Integer.valueOf(editSecond.getText().toString());
                result = firstValue / secondValue;
                tvResult.setText("Your result is= "+ result);
            }
        });
    }
}
