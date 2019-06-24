package com.example.planetssearchview.network;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitSingleton {

    private static final String BASE_URL = "https://raw.githubusercontent.com";
    private static Retrofit retrofitSingleInstance;
    private static PlanetsService serviceSingleInstance;

    private RetrofitSingleton() {
    }

    private static Retrofit getRetrofitSingleInstance() {
        if (retrofitSingleInstance == null) {
            retrofitSingleInstance = new Retrofit.Builder()
              .baseUrl(BASE_URL)
              .addConverterFactory(GsonConverterFactory.create())
              .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
              .build();
            return retrofitSingleInstance;
        } else {
            return retrofitSingleInstance;
        }
    }

    public static PlanetsService getPlanetsSerivce() {
        if (serviceSingleInstance == null) {
            serviceSingleInstance = getRetrofitSingleInstance().create(PlanetsService.class);
        }
        return serviceSingleInstance;
    }
}
