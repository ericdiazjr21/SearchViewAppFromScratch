package com.example.planetssearchview.model;

import java.util.List;

public final class PlanetsResponse {

    private final List<Planet> planets;

    public PlanetsResponse(List<Planet> planets) {
        this.planets = planets;
    }

    public List<Planet> getPlanets() {
        return planets;
    }
}
