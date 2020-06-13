package com.example.application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ActivityTwo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
    }

    public void calculateBMI(View view) {
        double height=0;
        double weight=0;
        double bmi=0;
        String msg="";
        EditText et1=(EditText) findViewById(R.id.editText);
        EditText et2=(EditText) findViewById(R.id.editText2);
        Button b1=(Button) findViewById(R.id.button);
        TextView t1=(TextView) findViewById(R.id.textView2);
        TextView t2=(TextView) findViewById(R.id.textView3);

        weight=Double.parseDouble(et1.getText().toString());
        height=Double.parseDouble(et2.getText().toString());

        bmi= height * height;
        bmi= weight/bmi;
        t1.setText(String.valueOf(bmi));

        if (bmi<18) {
            msg="Under Weight";
        }else if (bmi>18 && bmi<25){
            msg="Normal";
        }else{
            msg="Over Weight";
        }
        t2.setText(msg);
    }
}
