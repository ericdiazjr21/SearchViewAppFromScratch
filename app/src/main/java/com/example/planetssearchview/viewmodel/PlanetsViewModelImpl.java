package com.example.planetssearchview.viewmodel;

import android.arch.lifecycle.ViewModel;

import com.example.planetssearchview.model.Planet;
import com.example.planetssearchview.model.PlanetsResponse;
import com.example.planetssearchview.repository.PlanetsRepository;

import java.util.LinkedList;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public final class PlanetsViewModelImpl extends ViewModel implements PlanetsViewModel {

    private final PlanetsRepository planetsRepository;

    public PlanetsViewModelImpl() {
        this.planetsRepository = new PlanetsRepository();
    }

    @Override
    public Single<LinkedList<Planet>> getPlanets() {
        return planetsRepository.initNetworkCall()
          .subscribeOn(Schedulers.io())
          .map(PlanetsResponse::getPlanets);
    }
}
