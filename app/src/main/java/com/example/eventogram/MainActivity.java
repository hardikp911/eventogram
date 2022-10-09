package com.example.eventogram;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;

import com.example.eventogram.Adapters.EventsRecyclerViewAdapter;
import com.example.eventogram.Repository.EventsRepo;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener  {

//    RecyclerView recyclerView;
    EventsRecyclerViewAdapter eventsRecyclerViewAdapter;

    //drawer icon
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView menuicon;
    Button eventDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        recyclerView = findViewById(R.id.recyclerView);
        initRecyclerView();
        eventDetails = findViewById(R.id.Details);

        //drawer icon values to call
        menuicon = findViewById(R.id.menu_icon);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_layout);


        eventDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),event_On_Details.class);
                startActivity(intent);
            }
        });
        //navigation Drawer working calling a function to perform tasks
        navigationDrawer();
    }
    /**
     * Called when an item in the navigation menu is selected.
     *
     * @param item The selected item
     * @return true to display the item as the selected item
     */   @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {


        int id = item.getItemId();



        if(id == R.id.nav_profile)
        {
            startActivity(new Intent(getApplicationContext(), logoutProfile.class));
            finish();


        }

//        Switch(item.getItemId()){
//            case R.id.nav_all_catigories:{
//                startActivity(new Intent(getApplicationContext(), AllCategories.class));
//                break;
//            }
//
//        }


        return true;
    }

    private void navigationDrawer() {
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);
        menuicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(drawerLayout.isDrawerVisible(GravityCompat.START)){
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                else{
                    drawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });
    }
    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerVisible(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else
            super.onBackPressed();
    }

    private void initRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        eventsRecyclerViewAdapter = new EventsRecyclerViewAdapter(EventsRepo.getEventsRepo().getEventModelList());
        Log.i("data-->",""+ EventsRepo.getEventsRepo().getEventModelList().size());
//        recyclerView.setLayoutManager(linearLayoutManager);
//        recyclerView.setAdapter(eventsRecyclerViewAdapter);
        eventsRecyclerViewAdapter.notifyDataSetChanged();
    }


}