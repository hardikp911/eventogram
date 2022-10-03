package com.example.eventogram.helperClass.HomeAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eventogram.R;

import java.util.ArrayList;



public class MostViewedAdpater extends RecyclerView.Adapter<MostViewedAdpater.FeaturedViewHolder> {

    public ArrayList<MostViewedHelperClass> featuredLocations;
    Context context;
    public ArrayList<MostViewedHelperClass> mostViewedHelperClass;

    public  MostViewedAdpater(Context context,ArrayList<MostViewedHelperClass> featuredLocations ){

        this.context = context;
        this.mostViewedHelperClass =featuredLocations;
    }


    public MostViewedAdpater(ArrayList<MostViewedHelperClass> featuredLocations) {
        this.featuredLocations = featuredLocations;
    }

    @NonNull
    @Override
    public FeaturedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // this is where you inflate the layout (Giving a look to our rows
        LayoutInflater inflater = LayoutInflater.from(context);
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.feature_card_design,parent,false);
        View view = inflater.inflate(R.layout.most_viewed_card_design,parent,false);
        FeaturedViewHolder featuredViewHolder = new FeaturedViewHolder(view);

        return featuredViewHolder ;


    }

    @Override
    public void onBindViewHolder(@NonNull FeaturedViewHolder holder, int position) {
       // assigning values to the views we created in the recycler_view_row layout file
     // based on the position of the recycler view
        MostViewedHelperClass featuredHelperclass = featuredLocations.get(position);
        holder.image.setImageResource(featuredHelperclass.getImage());
        holder.title.setText(featuredHelperclass.getTitle());
        holder.desc.setText(featuredHelperclass.getDesc());



    }

    @Override
    public int getItemCount() {
        // the recycler view just wants to know the number of items you want displayed


        return featuredLocations.size();
    }

    public  static  class FeaturedViewHolder extends RecyclerView.ViewHolder{

        // grabbing the views from our recycler_view_row layout file
        // Kinda like in the onCreate method

        ImageView image;
        TextView title, desc;

        public FeaturedViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.featured_image_1);
            title = itemView.findViewById(R.id.featured_Title_1);
            desc = itemView.findViewById(R.id.featured_description_1);

        }
    }
}
