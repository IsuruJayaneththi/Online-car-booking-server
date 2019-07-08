package com.example.issa.pdm_project_2018_server.Service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;

import com.example.issa.pdm_project_2018_server.Model.Oil_Change_Records;
import com.example.issa.pdm_project_2018_server.Model.Request;
import com.example.issa.pdm_project_2018_server.OilChangeStatus;
import com.example.issa.pdm_project_2018_server.OrderStatus;
import com.example.issa.pdm_project_2018_server.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;

public class ListenOil extends Service implements ChildEventListener {

    FirebaseDatabase db;
    DatabaseReference oilchange;

    //Press Ctrl+o
    @Override
    public void onCreate() {
        super.onCreate();
        db = FirebaseDatabase.getInstance();
        oilchange = db.getReference("Oil Change Records");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        oilchange.addChildEventListener(this);
        return super.onStartCommand(intent, flags, startId);
    }

    public ListenOil() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
        //Trigger here
        Oil_Change_Records oil = dataSnapshot.getValue(Oil_Change_Records.class);
        if (oil.getStatus().equals("0"))
            showNotification(dataSnapshot.getKey(),oil);
    }

    private void showNotification(String key, Oil_Change_Records oil) {
        Intent intent = new Intent(getBaseContext(), OilChangeStatus.class);
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