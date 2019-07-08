package com.example.planetssearchview.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

public final class ViewModelFactory implements ViewModelProvider.Factory {

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(PlanetsViewModelImpl.class)) {
            return (T) new PlanetsViewModelImpl();
        } else {
            throw new IllegalArgumentException("creates only PlanetsViewModel.class objects");
        }
    }
}
