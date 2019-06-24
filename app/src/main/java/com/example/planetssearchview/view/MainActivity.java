package com.example.planetssearchview.view;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;

import com.example.planetssearchview.R;
import com.example.planetssearchview.view.recyclerview.PlanetsAdapter;
import com.example.planetssearchview.model.Planet;
import com.example.planetssearchview.network.NetworkInterface;
import com.example.planetssearchview.repository.PlanetsRepository;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NetworkInterface {

    private RecyclerView recyclerView;
    private SearchView searchView;
    private PlanetsAdapter planetsAdapter;
    private List<Planet> planetList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        setRecyclerView();
        OnTextChangedListener();
    }

    private void findViews() {
        recyclerView = findViewById(R.id.planets_recycler_view);
        searchView = findViewById(R.id.search_view);
    }

    @SuppressLint("CheckResult")
    private void setRecyclerView() {
        new PlanetsRepository()
                .initNetworkCall(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void OnTextChangedListener() {
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                List<Planet> newPlanetList = new ArrayList<>();
                for (Planet p : planetList) {
                    if (p.getName().toLowerCase().startsWith(s.toLowerCase())){
                        newPlanetList.add(p);
                    }
                }
                planetsAdapter.setData(newPlanetList);
                return false;
            }
        });
    }

    @Override
    public void onSuccess(List<Planet> planets) {
        planetList = planets;
        planetsAdapter = new PlanetsAdapter(planetList);
        recyclerView.setAdapter(planetsAdapter);
    }

    @Override
    public void onFailure(Throwable t) {

    }
}
