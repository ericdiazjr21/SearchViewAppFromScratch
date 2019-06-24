package com.example.planetssearchview.repository;

import com.example.planetssearchview.model.PlanetsResponse;
import com.example.planetssearchview.network.RetrofitSingleton;

import io.reactivex.Observable;

public final class PlanetsRepository {

    public Observable<PlanetsResponse> initNetworkCall() {
        return RetrofitSingleton.getPlanetsSerivce().getResponse();
    }
}
