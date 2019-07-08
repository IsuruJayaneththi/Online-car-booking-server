package com.example.issa.pdm_project_2018_server;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.issa.pdm_project_2018_server.Common.Common;
import com.example.issa.pdm_project_2018_server.Interface.ItemClickListener;
import com.example.issa.pdm_project_2018_server.Model.Fill_Up_Records;
import com.example.issa.pdm_project_2018_server.Model.Oil_Change_Records;
import com.example.issa.pdm_project_2018_server.ViewHolder.FillupViewHolder;
import com.example.issa.pdm_project_2018_server.ViewHolder.OilChangeViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.jaredrummler.materialspinner.MaterialSpinner;

public class FillupStatus extends AppCompatActivity {

    public RecyclerView recyclerView;
    public RecyclerView.LayoutManager layoutManager;

    FirebaseDatabase database;
    DatabaseReference fillup;

    MaterialSpinner spinner;


    FirebaseRecyclerAdapter<Fill_Up_Records,FillupViewHolder> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_fillup_status);

        //Firebase
        database = FirebaseDatabase.getInstance();
        fillup = database.getReference("Fill_Up_Records");

        recyclerView = (RecyclerView)findViewById(R.id.listOrders);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        loadOfillup();  //load all Oil records
    }

    private void loadOfillup() {

        adapter = new FirebaseRecyclerAdapter<Fill_Up_Records, FillupViewHolder>(
                Fill_Up_Records.class,
                R.layout.fillup_layout,
                FillupViewHolder.class,
                fillup
        ) {
            @Override
            protected void populateViewHolder(FillupViewHolder viewHolder, Fill_Up_Records model, int position) {
                viewHolder.fill_id.setText(adapter.getRef(position).getKey());
                viewHolder.fill_status.setText(Common.convertCode1ToStatus(model.getStatus()));
                viewHolder.vehiclename.setText(model.getVehiclename());
                viewHolder.location.setText(model.getFilledlocation());
                viewHolder.startmeter.setText(model.getStartmeter());
                viewHolder.endmeter.setText(model.getEndmeter());
                viewHolder.cost.setText(model.getCost());
                viewHolder.noofliter.setText(model.getNoofliter());

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

    @Override
    public void finish(){
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

    }
}
