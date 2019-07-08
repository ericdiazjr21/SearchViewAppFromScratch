package com.example.planetssearchview.network;

import com.example.planetssearchview.model.PlanetsResponse;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface PlanetsService {

    @GET("JDVila/storybook/master/planets.json")
    Single<PlanetsResponse> getResponse();
}
