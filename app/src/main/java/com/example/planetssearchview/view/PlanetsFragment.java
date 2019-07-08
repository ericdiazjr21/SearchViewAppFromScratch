package com.example.planetssearchview.view;


import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.planetssearchview.R;
import com.example.planetssearchview.view.recyclerview.PlanetsAdapter;
import com.example.planetssearchview.viewmodel.PlanetsViewModel;
import com.example.planetssearchview.viewmodel.PlanetsViewModelImpl;
import com.example.planetssearchview.viewmodel.ViewModelFactory;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class PlanetsFragment extends Fragment {

    private static final String TAG = "PlanetsFragment";
    private Disposable disposable;
    private PlanetsAdapter planetsAdapter;

    public PlanetsFragment() {
    }

    public static PlanetsFragment newInstance() {
        return new PlanetsFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.planets_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initializeRecyclerView(view);
        subscribe(getPlanetsViewModel());
    }

    private void initializeRecyclerView(@NonNull View view) {
        RecyclerView recyclerView = view.findViewById(R.id.planets_recycler_view);
        planetsAdapter = new PlanetsAdapter();
        recyclerView.setAdapter(planetsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
    }

    private void subscribe(@NonNull final PlanetsViewModel planetsViewModel) {
        disposable = planetsViewModel.getPlanets()
          .observeOn(AndroidSchedulers.mainThread())
          .subscribe(allPlanets -> planetsAdapter.setData(allPlanets),
            throwable -> Log.d(TAG, "error: " + throwable.getMessage()));
    }

    private PlanetsViewModel getPlanetsViewModel() {
        return ViewModelProviders
          .of(PlanetsFragment.this, new ViewModelFactory())
          .get(PlanetsViewModelImpl.class);
    }

    @Override
    public void onDestroy() {
        disposable.dispose();
        super.onDestroy();
    }
}
