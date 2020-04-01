package com.example.application36;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class BoundMyService extends Service {
    public BoundMyService() {
    }

    public class MyLocalBinder extends Binder{
        BoundMyService getService(){
            return BoundMyService.this;
        }
    }
    private final IBinder myBinder = new MyLocalBinder();

    public String getCurrentTime(){
        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss", Locale.US);
        return df.format(new Date());
    }

    @Override
    public IBinder onBind(Intent intent) {
        return myBinder;
    }
}
