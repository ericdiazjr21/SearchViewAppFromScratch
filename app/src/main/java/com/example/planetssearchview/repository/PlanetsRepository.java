package com.example.planetssearchview.repository;

import com.example.planetssearchview.model.PlanetsResponse;
import com.example.planetssearchview.network.RetrofitSingleton;

import io.reactivex.Single;

public final class PlanetsRepository {

    public Single<PlanetsResponse> initNetworkCall() {
        return RetrofitSingleton.getPlanetsSerivce().getResponse();
    }
}
