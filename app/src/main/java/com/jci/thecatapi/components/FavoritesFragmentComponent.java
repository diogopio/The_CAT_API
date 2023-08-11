package com.jci.thecatapi.components;

import com.jci.thecatapi.CatModule;
import com.jci.thecatapi.ui.favorites.FavoritesFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = CatModule.class)
public interface FavoritesFragmentComponent {
    void inject(FavoritesFragment fragment);
}