package com.example.planetssearchview.repository;

import android.annotation.SuppressLint;

import com.example.planetssearchview.network.NetworkInterface;
import com.example.planetssearchview.network.PlanetsService;
import com.example.planetssearchview.network.RetrofitSingleton;


import io.reactivex.android.schedulers.AndroidSchedulers;

import io.reactivex.schedulers.Schedulers;

public final class PlanetRepository {

    public PlanetRepository() {}

    @SuppressLint("CheckResult")
    public void requestJsonFromRetrofit(NetworkInterface networkInterface) {
        RetrofitSingleton.getRetrofitSingleInstance()
                .create(PlanetsService.class)
                .getResponse()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(planetsResponse -> planetsResponse.getPlanets())
                .subscribe(networkInterface::onSuccess,
                        networkInterface::onFailure);
    }
}
