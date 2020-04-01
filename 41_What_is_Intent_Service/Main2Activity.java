package com.example.application36;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.application36.BoundMyService.MyLocalBinder;

public class Main2Activity extends AppCompatActivity {
    private static final String TAG="com.example.application36";
    BoundMyService myService;
    boolean isBound = false;

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

        Intent b = new Intent(this, BoundMyService.class);
        bindService(b, myConnection, Context.BIND_AUTO_CREATE);
    }

    private ServiceConnection myConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyLocalBinder binder = (MyLocalBinder) service;
            myService = binder.getService();
            isBound = true;
            Log.i(TAG,"Bound Service onServiceConnected");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;
            Log.i(TAG,"Bound Service onServiceDisconnected");
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(myConnection);
        Log.i(TAG,"Bound Service onDestroy");
    }

    public void showTime(View view){
        String time = myService.getCurrentTime();
        TextView text = (TextView) findViewById(R.id.textView2);
        text.setText(time);
    }
}
