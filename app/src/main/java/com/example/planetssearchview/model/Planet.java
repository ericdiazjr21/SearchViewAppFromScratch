package com.example.planetssearchview.model;

public final class Planet {

    private final String name;
    private final String number;
    private final String image;

    public Planet(String name, String number, String image) {
        this.name = name;
        this.number = number;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getImage() {
        return image;
    }
}