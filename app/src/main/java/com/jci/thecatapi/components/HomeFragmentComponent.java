package com.jci.thecatapi.components;

import com.jci.thecatapi.CatModule;
import com.jci.thecatapi.ui.home.HomeFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = CatModule.class)
public interface HomeFragmentComponent {
    void inject(HomeFragment fragment);
}