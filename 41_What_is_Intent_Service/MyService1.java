package com.example.application36;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService1 extends Service {
    private static final String TAG="com.example.application36";
    public MyService1() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "Service onStartCommand");

        Runnable run = new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<5; i++){
                    long futureTime = System.currentTimeMillis()+5000;
                    while (System.currentTimeMillis()<futureTime){
                        synchronized (this){//The Java synchronized keyword is an essential tool in concurrent programming in Java. Its overall purpose is to only allow one thread at a time into a particular section of code thus allowing us to protect, for example, variables or data from being corrupted by simultaneous modifications from different threads.
                            try {
                                wait(futureTime-System.currentTimeMillis());
                                Log.i(TAG,"Service is running");
                            }catch (Exception e) {

                            }
                        }
                    }
                }
            }
        };
        Thread myThread = new Thread(run);
        myThread.start();
        return Service.START_STICKY;
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "Service is onDestroyed");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
