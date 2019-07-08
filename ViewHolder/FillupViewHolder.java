package com.example.issa.pdm_project_2018_server.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.View;
import android.widget.TextView;

import com.example.issa.pdm_project_2018_server.Interface.ItemClickListener;
import com.example.issa.pdm_project_2018_server.R;

public class FillupViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnCreateContextMenuListener{

    public TextView fill_id,fill_status,vehiclename,location,startmeter,endmeter,cost,noofliter;

    private ItemClickListener itemClickListener;

    public FillupViewHolder(View itemView) {
        super(itemView);

        fill_id= (TextView)itemView.findViewById(R.id.fill_id);
        fill_status = (TextView)itemView.findViewById(R.id.fill_status);
        vehiclename = (TextView)itemView.findViewById(R.id.vehiclename);
        location = (TextView)itemView.findViewById(R.id.location);
        startmeter = (TextView)itemView.findViewById(R.id.startmeter);
        endmeter = (TextView)itemView.findViewById(R.id.endmeter);
        cost = (TextView)itemView.findViewById(R.id.cost);
        noofliter = (TextView)itemView.findViewById(R.id.noofliter);

        itemView.setOnClickListener(this);
        itemView.setOnCreateContextMenuListener(this);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View v) {
        itemClickListener.onClick(v,getAdapterPosition(),false);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderTitle("Select The Action");

        menu.add(0,0,getAdapterPosition(),"Update");

    }
}