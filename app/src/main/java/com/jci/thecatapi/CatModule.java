package com.jci.thecatapi;

import android.content.Context;
import android.content.SharedPreferences;

import com.jci.thecatapi.api.ApiService;
import com.jci.thecatapi.localStorage.CatDatabase;
import com.jci.thecatapi.localStorage.DatabaseClient;
import com.jci.thecatapi.services.CatService;
import com.jci.thecatapi.ui.detail.DetailViewModel;
import com.jci.thecatapi.ui.favorites.FavoritesViewModel;
import com.jci.thecatapi.ui.home.HomeViewModel;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class CatModule {
    private final Context context;

    public CatModule(Context context) {
        this.context = context;
    }

    @Singleton
    @Provides
    public Context provideContext() {
        return context;
    }
    @Singleton
    @Provides
    public SharedPreferences provideSharedPreferences(Context context){
        return context.getSharedPreferences("data", Context.MODE_PRIVATE);
    }
    @Singleton
    @Provides
    public ApiService provideApiService() {
        return new ApiService();
    }
    @Singleton
    @Provides
    public CatDatabase provideCatDatabase(Context context) {
        return DatabaseClient.getInstance(context).getAppDatabase();
    }
    @Singleton
    @Provides
    public CatService provideCatService(CatDatabase catDatabase, ApiService apiService, SharedPreferences sharedPreferences) {
        return new CatService(catDatabase, apiService, sharedPreferences);
    }
    @Provides
    public HomeViewModel provideHomeViewModel(CatService catService) {
        return new HomeViewModel(catService);
    }
    @Provides
    public FavoritesViewModel provideFavoritesViewModel(CatService catService) {
        return new FavoritesViewModel(catService);
    }

    @Provides
    public DetailViewModel provideDetailViewModel(CatService catService) {
        return new DetailViewModel(catService);
    }
}
