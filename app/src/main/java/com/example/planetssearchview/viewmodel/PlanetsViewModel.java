package com.example.planetssearchview.viewmodel;

import com.example.planetssearchview.model.Planet;

import java.util.LinkedList;

import io.reactivex.Single;

public interface PlanetsViewModel {
    Single<LinkedList<Planet>> getPlanets();
}
