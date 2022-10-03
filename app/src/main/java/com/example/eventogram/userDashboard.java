package com.example.eventogram;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Switch;

import com.example.eventogram.R;
import com.example.eventogram.helperClass.HomeAdapter.FeaturedAdapter;
import com.example.eventogram.helperClass.HomeAdapter.FeaturedHelperclass;
import com.example.eventogram.helperClass.HomeAdapter.MostViewedHelperClass;
import com.example.eventogram.helperClass.HomeAdapter.MostViewedAdpater;
import com.google.android.material.navigation.NavigationView;


import java.util.ArrayList;

public class userDashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener  {

    RecyclerView featuredRecycler,featuredRecycler1;
    RecyclerView.Adapter adapter;
    //drawer

    ImageView menuicon;
    DrawerLayout drawerLayout;
    NavigationView navigationView;


// most view card view trying to clickable

    ArrayList<MostViewedHelperClass> mostViewedHelperClasses = new ArrayList<>();
    int[] mostViewedHelperClassesimage = {R.drawable.collegestudy,
            R.drawable.collegestudy
           ,R.drawable.collegestudy,
            R.drawable.collegestudy,
            R.drawable.collegestudy,
            R.drawable.collegestudy};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_user_dashboard);

        featuredRecycler = findViewById(R.id.featured_recycler);
        featuredRecycler();
        featuredRecycler1 = findViewById(R.id.featured_recycler1);

//        featuredRecycler1();
//        featuredRecycler2 = findViewById(R.id.featured_recycler2);
//        featuredRecycler();



// start of mostViewed class view

        setUpMostViewed();
//        ArrayList<MostViewedHelperClass> featuredViewHolder = null;
//        MostViewedAdpater adapter = new MostViewedAdpater(this,featuredViewHolder);
//        ArrayList<MostViewedHelperClass> mostViewedLocations = new ArrayList<>();
//         featuredRecycler1.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        featuredRecycler1.setAdapter(adapter);
        featuredRecycler1.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false));
//        adapter = new MostViewedAdpater(mostViewedLocations);
//        featuredRecycler1.setAdapter(adapter)




        // end of mostViewed class view


        //menu hooks
        menuicon = findViewById(R.id.menu_icon);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_layout);

        //recycler practice


        //navigation Drawer


        navigationDrawer();

    }
//navigation
    private void navigationDrawer() {
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);
        menuicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(drawerLayout.isDrawerVisible(GravityCompat.START)){
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                else
                {
                    drawerLayout.openDrawer(GravityCompat.START);


                }


            }
        });

    }

    //most viewed recycler view

    private void setUpMostViewed(){

        String[] mostViewedTitle = getResources().getStringArray(R.array.Most_viewed_photos_title);
        String[] mostViewedDesc = getResources().getStringArray(R.array.Most_viewed_photos_desc);
        for ( int i = 0 ; i <mostViewedTitle.length ;i++ ) {
            mostViewedHelperClasses.add (new MostViewedHelperClass(mostViewedTitle[i],
                    mostViewedDesc[i],mostViewedHelperClassesimage[i]));

            }

    }



    //most viewed ended here

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerVisible(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else
        super.onBackPressed();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {


        int id = item.getItemId();

        if(id == R.id.nav_all_catigories)
        {
            startActivity(new Intent(getApplicationContext(), AllCategories.class));

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

    //recycler view

//    private void featuredRecycler1() {
//
//        featuredRecycler1.setHasFixedSize(true);
//      featuredRecycler1.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
//
//        ArrayList<MostViewedHelperClass> mostViewedLocations = new ArrayList<>();
//        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.collegealert,"collegeAlert", " blablablablablablbalbalba"));
//        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.collegeparty,"collegeParty", " blablablablablablbalbalba"));
//        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.collegestudy,"collegeStudy", " blablablablablablbalbalba"));
//        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.collegealert,"collegeAlert", " blablablablablablbalbalba"));
//        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.collegeparty,"collegeParty", " blablablablablablbalbalba"));
//        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.collegestudy,"collegeStudy", " blablablablablablbalbalba"));
//
//
//        adapter = new MostViewedAdpater(mostViewedLocations);
//        featuredRecycler1.setAdapter(adapter);
//    }

    private void featuredRecycler() {



        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        ArrayList<FeaturedHelperclass> featuredLocations = new ArrayList<>();
        featuredLocations.add(new FeaturedHelperclass(R.drawable.collegealert,"collegeAlert", " blablablablablablbalbalba"));
        featuredLocations.add(new FeaturedHelperclass(R.drawable.collegeparty,"collegeParty", " blablablablablablbalbalba"));
        featuredLocations.add(new FeaturedHelperclass(R.drawable.collegestudy,"collegeStudy", " blablablablablablbalbalba"));
        featuredLocations.add(new FeaturedHelperclass(R.drawable.collegealert,"collegeAlert", " blablablablablablbalbalba"));
        featuredLocations.add(new FeaturedHelperclass(R.drawable.collegeparty,"collegeParty", " blablablablablablbalbalba"));
        featuredLocations.add(new FeaturedHelperclass(R.drawable.collegestudy,"collegeStudy", " blablablablablablbalbalba"));

//        GradientDrawable gradien1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT,new int []{0xffeff400, 0xffaff600});
        adapter = new FeaturedAdapter(featuredLocations);
        featuredRecycler.setAdapter(adapter);
    }



}