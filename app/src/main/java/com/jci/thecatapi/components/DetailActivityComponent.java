package com.jci.thecatapi.components;

import com.jci.thecatapi.CatModule;
import com.jci.thecatapi.ui.detail.DetailActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = CatModule.class)
public interface DetailActivityComponent {
    void inject(DetailActivity activity);
}