package com.example.planetssearchview.viewmodel;

import android.arch.lifecycle.ViewModel;

import com.example.planetssearchview.model.Planet;
import com.example.planetssearchview.model.PlanetsResponse;
import com.example.planetssearchview.repository.PlanetsRepository;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public final class PlanetsViewModel extends ViewModel {

    private final PlanetsRepository planetsRepository;

    public PlanetsViewModel() {
        this.planetsRepository = new PlanetsRepository();
    }

    public Observable<List<Planet>> getPlanetsObservable() {
        return planetsRepository.initNetworkCall()
          .subscribeOn(Schedulers.io())
          .map(PlanetsResponse::getPlanets);
    }
}
