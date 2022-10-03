package com.example.eventogram.helperClass.HomeAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eventogram.R;

import java.util.ArrayList;

public class FeaturedAdapter extends RecyclerView.Adapter<FeaturedAdapter.FeaturedViewHolder> {


    ArrayList<FeaturedHelperclass> featuredLocations;

    public FeaturedAdapter(ArrayList<FeaturedHelperclass> featuredLocations) {
        this.featuredLocations = featuredLocations;

    }

    @NonNull
    @Override
    public FeaturedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.feature_card_design,parent,false);
        FeaturedViewHolder featuredViewHolder = new FeaturedViewHolder(view);
        return featuredViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FeaturedViewHolder holder, int position) {

        FeaturedHelperclass featuredHelperclass = featuredLocations.get(position);
        holder.image.setImageResource(featuredHelperclass.getImage());
        holder.title.setText(featuredHelperclass.getTitle());
        holder.desc.setText(featuredHelperclass.getDesc());



    }

    @Override
    public int getItemCount() {

        return featuredLocations.size();
    }

    public class FeaturedViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView title, desc;

        public FeaturedViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.featured_image_1);
            title = itemView.findViewById(R.id.featured_Title_1);
            desc = itemView.findViewById(R.id.featured_description_1);
            // recycler view


        }
    }
}
