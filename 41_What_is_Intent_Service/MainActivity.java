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
//IntentService class is goint to create a thread for us.
        Intent intent = new Intent(this, MyIntentService.class);
        startService(intent);
//Service class uses the application's main thread, while IntentService creates a worker thread and uses that thread to run the service. IntentService creates a queue that passes one intent at a time to onHandleIntent() . Thus, implementing a multi-thread should be made by extending Service class directly.
//both services run all the time even we close the application.
        Intent intent1 = new Intent(this,MyService1.class);
        startService(intent1);//In Service class we need to create our own thread
    }

    public void firstButtonClick(View view){
        Intent intent = new Intent(this, Main2Activity.class) ;
        final EditText firstInput = (EditText) findViewById(R.id.editText);
        String usermessage = firstInput.getText().toString();
        intent.putExtra("firstMessage", usermessage);
        startActivity(intent);
    }

}
