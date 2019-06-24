package com.example.planetssearchview.view.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.planetssearchview.R;
import com.example.planetssearchview.model.Planet;
import com.example.planetssearchview.view.recyclerview.PlanetsViewHolder;

import java.util.List;

public class PlanetsAdapter extends RecyclerView.Adapter<PlanetsViewHolder> {

    private List<Planet> planets;

    public PlanetsAdapter(List<Planet> planets) {
        this.planets = planets;
    }

    @NonNull
    @Override
    public PlanetsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.planets_item_view,viewGroup,false);
        return new PlanetsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlanetsViewHolder planetsViewHolder, int i) {
        planetsViewHolder.onBind(planets.get(i));
    }

    @Override
    public int getItemCount() {
        return planets.size();
    }

    public void setData(List<Planet> planets){
        this.planets = planets;
        notifyDataSetChanged();
    }
}
