package com.example.application36;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyIntentService extends IntentService {
    private static final String TAG="com.example.application36";//Analyze->code inspect->project default uncheck Too Long Log tag

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.i(TAG,"The service has started");
    }
}
