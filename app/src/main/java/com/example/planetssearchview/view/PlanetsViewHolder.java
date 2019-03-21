package com.example.planetssearchview.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.planetssearchview.R;
import com.example.planetssearchview.model.Planet;
import com.squareup.picasso.Picasso;

public class PlanetsViewHolder extends RecyclerView.ViewHolder {

    private ImageView planetsImageView;
    private TextView nameTextView;
    private TextView numberTextView;

    public PlanetsViewHolder(@NonNull View itemView) {
        super(itemView);
        findViews(itemView);
    }

    private void findViews(@NonNull View itemView) {
        planetsImageView = itemView.findViewById(R.id.planets_image_view);
        nameTextView = itemView.findViewById(R.id.name_text_view);
        numberTextView = itemView.findViewById(R.id.number_text_view);
    }

    public void onBind(Planet planet) {
        setViews(planet);
    }

    private void setViews(Planet planet) {
        Picasso.get().load(planet.getImage()).into(planetsImageView);
        nameTextView.setText(planet.getName());
        numberTextView.setText(planet.getNumber());
    }
}
