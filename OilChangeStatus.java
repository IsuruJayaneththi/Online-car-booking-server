package com.example.issa.pdm_project_2018_server;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.issa.pdm_project_2018_server.Common.Common;
import com.example.issa.pdm_project_2018_server.Interface.ItemClickListener;
import com.example.issa.pdm_project_2018_server.Model.Oil_Change_Records;
import com.example.issa.pdm_project_2018_server.Model.Request;
import com.example.issa.pdm_project_2018_server.ViewHolder.OilChangeViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.jaredrummler.materialspinner.MaterialSpinner;

public class OilChangeStatus extends AppCompatActivity {

    public RecyclerView recyclerView;
    public RecyclerView.LayoutManager layoutManager;

    FirebaseDatabase database;
    DatabaseReference oilchange;

    MaterialSpinner spinner;


    FirebaseRecyclerAdapter<Oil_Change_Records,OilChangeViewHolder> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_oil_change_status);
        //Firebase
        database = FirebaseDatabase.getInstance();
        oilchange = database.getReference("Oil Change Records");

        recyclerView = (RecyclerView)findViewById(R.id.listOrders);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        loadOilchange();  //load all Oil records
    }

    private void loadOilchange() {
        adapter = new FirebaseRecyclerAdapter<Oil_Change_Records, OilChangeViewHolder>(
                Oil_Change_Records.class,
                R.layout.oilchange_layout,
                OilChangeViewHolder.class,
                oilchange
        ) {
            @Override
            protected void populateViewHolder(OilChangeViewHolder viewHolder, Oil_Change_Records model, int position) {
                viewHolder.oil_id.setText(adapter.getRef(position).getKey());
                viewHolder.oil_status.setText(Common.convertCode1ToStatus(model.getStatus()));
                viewHolder.oiltype.setText(model.getOiltype());
                viewHolder.oilamount.setText(model.getAmount());
                viewHolder.oillocation.setText(model.getLocation());
                viewHolder.oiltime.setText(model.getTime());
                viewHolder.oildate.setText(model.getDate());

                viewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int position, boolean isLongClick) {
                        //just implement it to fix crash when click to this item
                    }
                });
            }
        };
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);
    }

    //Press ctrl+o

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getTitle().equals(Common.UPDATE))
            showUpdateDialog(adapter.getRef(item.getOrder()).getKey(),adapter.getItem(item.getOrder()));
        else if (item.getTitle().equals(Common.DELETE))
            deleteOrder(adapter.getRef(item.getOrder()).getKey());
        return super.onContextItemSelected(item);
    }

    private void deleteOrder(String key) {
        oilchange.child(key).removeValue();
    }

    private void showUpdateDialog(String key, final Oil_Change_Records item) {
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(OilChangeStatus.this);
        alertDialog.setTitle("Update Event");
        alertDialog.setMessage("Please choose status");

        LayoutInflater inflater = this.getLayoutInflater();
        final View view = inflater.inflate(R.layout.update_oil_change_layout,null);

        spinner = (MaterialSpinner)view.findViewById(R.id.statusSpinner);
        spinner.setItems("Placed","Seen");

        alertDialog.setView(view);

        final String localKey = key;
        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                item.setStatus(String.valueOf(spinner.getSelectedIndex()));
                oilchange.child(localKey).setValue(item);
            }
        });
        alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alertDialog.show();
    }
}
