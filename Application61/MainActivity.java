package com.example.application61;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNotification();
            }
        });
    }

    public void showNotification() {
        NotificationCompat.Builder  notification = new NotificationCompat.Builder(this);
        notification.setDefaults(NotificationCompat.DEFAULT_ALL);
        notification.setSmallIcon(R.drawable.apple);
        notification.setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.apple));
        notification.setTicker("This is a Ticker");
        notification.setWhen(System.currentTimeMillis());//on which time notification appears
        notification.setContentTitle("This is Title");
        notification.setContentText("Here is the Text");
        notification.setAutoCancel(true);
        notification.setPriority(NotificationCompat.PRIORITY_DEFAULT);

        Intent intent = new Intent(this,MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(pendingIntent);

        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(1,notification.build());
    }
}
