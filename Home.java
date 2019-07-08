package com.example.issa.pdm_project_2018_server;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.issa.pdm_project_2018_server.Common.Common;
import com.example.issa.pdm_project_2018_server.Service.ListenFill;
import com.example.issa.pdm_project_2018_server.Service.ListenOil;
import com.example.issa.pdm_project_2018_server.Service.ListenOrder;

public class Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    TextView txtFullName;

    private CardView booking,newuser;

    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // defining cards
        booking = (CardView) findViewById(R.id.booking);
        newuser = (CardView) findViewById(R.id.newuser);

        // Add Click listener to the cards
        booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent booking= new Intent(Home.this, com.example.issa.pdm_project_2018_server.Booking.class);
                startActivity(booking);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
        newuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent booking= new Intent(Home.this, com.example.issa.pdm_project_2018_server.SignUp.class);
                startActivity(booking);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Menu Management");
        setSupportActionBar(toolbar);



        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Set Name for user
        View headerView = navigationView.getHeaderView(0);
        txtFullName = (TextView)headerView.findViewById(R.id.txtFullName);
        txtFullName.setText(Common.currentUser.getName());


        //Call Service
        Intent orders = new Intent(Home.this, ListenOrder.class);
        startService(orders);


        Intent oil = new Intent(Home.this, ListenOil.class);
        startService(oil);

        Intent fill = new Intent(Home.this, ListenFill.class);
        startService(fill);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();



        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        if (id == R.id.nav_orders) {
            Intent orderIntent = new Intent(Home.this,OrderStatus.class);
            startActivity(orderIntent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }
        else if (id == R.id.nav_oilchange) {
            Intent oilIntent = new Intent(Home.this,OilChangeStatus.class);
            startActivity(oilIntent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }
        else if (id == R.id.nav_fillup) {
            Intent fillIntent = new Intent(Home.this,FillupStatus.class);
            startActivity(fillIntent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
