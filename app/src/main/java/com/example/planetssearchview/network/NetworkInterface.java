package com.example.planetssearchview.network;

import com.example.planetssearchview.model.Planet;

import java.util.List;

public interface NetworkInterface {

    void onSuccess(List<Planet> planets);

    void onFailure(Throwable t);


}
