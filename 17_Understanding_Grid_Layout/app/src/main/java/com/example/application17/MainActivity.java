package com.example.application17;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button myButton=(Button) findViewById(R.id.button7);

        myButton.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        TextView text=(TextView) findViewById(R.id.textView);
                        text.setText("button clicked");
                    }
                }
        );

    }
}
