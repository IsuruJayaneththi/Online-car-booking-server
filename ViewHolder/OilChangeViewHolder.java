package com.example.issa.pdm_project_2018_server.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.View;
import android.widget.TextView;


import com.example.issa.pdm_project_2018_server.Interface.ItemClickListener;
import com.example.issa.pdm_project_2018_server.R;

public class OilChangeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnCreateContextMenuListener{

    public TextView oil_id,oil_status,oiltype,oilamount,oillocation,oiltime,oildate;

    private ItemClickListener itemClickListener;

    public OilChangeViewHolder(View itemView) {
        super(itemView);

        oil_id= (TextView)itemView.findViewById(R.id.oil_id);
        oil_status = (TextView)itemView.findViewById(R.id.oil_status);
        oiltype = (TextView)itemView.findViewById(R.id.oiltype);
        oilamount = (TextView)itemView.findViewById(R.id.oilamount);
        oillocation = (TextView)itemView.findViewById(R.id.oillocation);
        oiltime = (TextView)itemView.findViewById(R.id.oiltime);
        oildate = (TextView)itemView.findViewById(R.id.oildate);

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
