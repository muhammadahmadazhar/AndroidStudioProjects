package com.example.application127;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edtfirstname,edtlastname;
    Button btninsert,btnview;
    SQL db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtfirstname=(EditText) findViewById(R.id.first_name);
        edtlastname=(EditText) findViewById(R.id.last_name);

        btninsert=(Button) findViewById(R.id.insert);
        btnview=(Button) findViewById(R.id.view);
        btninsert.setOnClickListener(this);
        btnview.setOnClickListener(this);

        db=new SQL(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.insert:
                boolean fine=true;
                try {
                    String strfirstname=edtfirstname.getText().toString();
                    String strlastname=edtlastname.getText().toString();
                    db.insertStudent(strfirstname,strlastname);
                }
                catch (Exception e){
                    fine=false;
                    String error=e.toString();
                    Dialog d=new Dialog(this);
                    d.setTitle("Error");
                    TextView tv=new TextView(this);
                    tv.setText(error);
                    d.setContentView(tv);
                    d.show();
                }
                finally {
                    if(fine){
                        Dialog d=new Dialog(this);
                        d.setTitle("Success");
                        TextView tv=new TextView(this);
                        tv.setText("Data is successfully inserted");
                        d.setContentView(tv);
                        d.show();
                    }
                }
                break;

            case R.id.view:
                Intent it=new Intent(getApplicationContext(),SQLView.class);
                startActivity(it);
                break;
        }
    }
}
