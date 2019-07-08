package com.example.planetssearchview.model;

import java.util.LinkedList;

public final class PlanetsResponse {

    private final LinkedList<Planet> planets;

    public PlanetsResponse(LinkedList<Planet> planets) {
        this.planets = planets;
    }

    public LinkedList<Planet> getPlanets() {
        return planets;
    }
}
