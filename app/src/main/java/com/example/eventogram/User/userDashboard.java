package com.example.eventogram.User;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.WindowManager;

import com.example.eventogram.R;
import com.example.eventogram.helperClass.HomeAdapter.FeaturedAdapter;
import com.example.eventogram.helperClass.HomeAdapter.FeaturedHelperclass;

import java.util.ArrayList;

public class userDashboard extends AppCompatActivity {

    RecyclerView featuredRecycler;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_user_dashboard);

        featuredRecycler = findViewById(R.id.featured_recycler);
        featuredRecycler();
        
    }

    private void featuredRecycler() {

        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        ArrayList<FeaturedHelperclass> featuredLocations = new ArrayList<>();
        featuredLocations.add(new FeaturedHelperclass(R.drawable.collegealert,"collegeAlert", " blablablablablablbalbalba"));
        featuredLocations.add(new FeaturedHelperclass(R.drawable.collegeparty,"collegeParty", " blablablablablablbalbalba"));
        featuredLocations.add(new FeaturedHelperclass(R.drawable.collegestudy,"collegeStudy", " blablablablablablbalbalba"));

        adapter = new FeaturedAdapter(featuredLocations);
        featuredRecycler.setAdapter(adapter);
    }
}