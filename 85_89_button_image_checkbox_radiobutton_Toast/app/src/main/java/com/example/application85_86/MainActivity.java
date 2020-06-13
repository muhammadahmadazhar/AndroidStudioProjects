package com.example.application85_86;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickCheckBox(View view) {
        TextView textView=(TextView) findViewById(R.id.textView);

        boolean checked=((CheckBox) view).isChecked();

        switch (view.getId()){

            case R.id.tea:
                if (checked)
                    textView.setText("tea");
                break;

            case R.id.milk:
                if (checked)
                    textView.setText("Milk");
                break;

        }


    }

    public void onClickImg(View view) {
        TextView textView=(TextView) findViewById(R.id.textView);
        textView.setText("Whatsapp");

        CharSequence text="This is a toast";
        int duration= Toast.LENGTH_LONG;
        Toast toast=Toast.makeText(this,text,duration);
        toast.show();
    }

    public void onClickRadio(View view) {
        TextView textView=(TextView) findViewById(R.id.textView);
        RadioGroup radioGroup=(RadioGroup) findViewById(R.id.radio_group);
        int id=radioGroup.getCheckedRadioButtonId();

        switch (id){

            case R.id.male:
                    textView.setText("Male");
                break;

            case R.id.female:
                    textView.setText("Female");
                break;

        }
    }
}
