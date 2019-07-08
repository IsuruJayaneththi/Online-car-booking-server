package com.example.issa.pdm_project_2018_server.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.issa.pdm_project_2018_server.Common.Common;
import com.example.issa.pdm_project_2018_server.Interface.ItemClickListener;
import com.example.issa.pdm_project_2018_server.R;

public class CarViewHolder extends RecyclerView.ViewHolder implements
        View.OnClickListener,
        View.OnCreateContextMenuListener
{


    public TextView car_name;
    public ImageView car_image;

    private ItemClickListener itemClickListener;

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public CarViewHolder(View itemView) {
        super(itemView);

        car_name = (TextView)itemView.findViewById(R.id.car_name);
        car_image = (ImageView)itemView.findViewById(R.id.car_image);

        itemView.setOnCreateContextMenuListener(this);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        itemClickListener.onClick(v,getAdapterPosition(),false);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderTitle("Select the action");

        menu.add(0,0,getAdapterPosition(), Common.UPDATE);
        menu.add(0,1,getAdapterPosition(), Common.DELETE);

    }
}
