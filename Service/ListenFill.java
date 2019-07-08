package com.example.issa.pdm_project_2018_server.Service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;

import com.example.issa.pdm_project_2018_server.FillupStatus;
import com.example.issa.pdm_project_2018_server.Model.Fill_Up_Records;
import com.example.issa.pdm_project_2018_server.Model.Oil_Change_Records;
import com.example.issa.pdm_project_2018_server.OilChangeStatus;
import com.example.issa.pdm_project_2018_server.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;

public class ListenFill extends Service implements ChildEventListener {

    FirebaseDatabase db;
    DatabaseReference fill;

    //Press Ctrl+o
    @Override
    public void onCreate() {
        super.onCreate();
        db = FirebaseDatabase.getInstance();
        fill = db.getReference("Fill_Up_Records");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        fill.addChildEventListener(this);
        return super.onStartCommand(intent, flags, startId);
    }

    public ListenFill() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
        //Trigger here
        Fill_Up_Records fill = dataSnapshot.getValue(Fill_Up_Records.class);
        if (fill.getStatus().equals("0"))
            showNotification(dataSnapshot.getKey(),fill);
    }

    private void showNotification(String key, Fill_Up_Records fill) {
        Intent intent = new Intent(getBaseContext(), FillupStatus.class);
        PendingIntent contentIntent = PendingIntent.getActivity(getBaseContext(),0,intent,0);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(getBaseContext());

        builder.setAutoCancel(true)
                .setDefaults(Notification.DEFAULT_ALL)
                .setTicker("VEHICLE")
                .setContentInfo("New Event")
                .setContentText("You have new event  #"+key)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentIntent(contentIntent);

        NotificationManager manager = (NotificationManager)getBaseContext().getSystemService(Context.NOTIFICATION_SERVICE);
        //If you want to show many notification , you need to give unique ID for each Notification
        int randomInt = new Random().nextInt(9999-1)+1;
        manager.notify(randomInt,builder.build());
    }

    @Override
    public void onChildChanged(DataSnapshot dataSnapshot, String s) {

    }

    @Override
    public void onChildRemoved(DataSnapshot dataSnapshot) {

    }

    @Override
    public void onChildMoved(DataSnapshot dataSnapshot, String s) {

    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }
}
