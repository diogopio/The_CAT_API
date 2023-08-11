package com.jci.thecatapi.services;

import android.content.SharedPreferences;

import com.jci.thecatapi.api.ApiService;
import com.jci.thecatapi.localStorage.CatDatabase;
import com.jci.thecatapi.localStorage.DatabaseClient;
import com.jci.thecatapi.model.Cat;

import java.util.List;

import javax.inject.Inject;

public class CatService {
    public interface SyncComplete { void onSyncComplete(); }
    public interface CatListListener { void onResult(List<Cat> catList); }
    public interface CatListener { void onResult(Cat result); }
    private final CatDatabase database;
    private final ApiService apiService;
    private final SharedPreferences prefs;
    private final String apiHashPref = "api_cats_hash";
    @Inject
    public CatService(CatDatabase database, ApiService apiService, SharedPreferences prefs){
        this.database = database;
        this.apiService = apiService;
        this.prefs = prefs;
    }
    private int getLocalHash(){
        return prefs.getInt(apiHashPref, -1);
    }
    private void setLocalHash(int hash) {
        prefs.edit().putInt(apiHashPref, hash).apply();
    }
    private void recreateLocalData(List<Cat> cats, SyncComplete syncComplete){
        int remoteHash = cats.hashCode();
        int localHash = getLocalHash();
        if(remoteHash != localHash){
            setLocalHash(remoteHash);
            new Thread(() -> {
                Integer[] favoritesIds = database.dataBaseAction().getFavoriteCatsIds();
                database.dataBaseAction().removeAllCats();
                cats.forEach(cat -> database.dataBaseAction().insertCat(cat));
                database.dataBaseAction().updateFavoriteCatsByIds(favoritesIds);
                syncComplete.onSyncComplete();
            }).start();
        }else{
            syncComplete.onSyncComplete();
        }
    }
    private void syncData(SyncComplete syncComplete){
        int localCacheMaxAgeInMillis = 10000;
        if (DatabaseClient.syncAgeInMillis != 0 && System.currentTimeMillis() - DatabaseClient.syncAgeInMillis < localCacheMaxAgeInMillis) {
            syncComplete.onSyncComplete();
            return;
        }
        DatabaseClient.syncAgeInMillis = System.currentTimeMillis();
        apiService.getCats(apiListener -> {
            if (apiListener != null) {
                recreateLocalData(apiListener, syncComplete);
                return;
            }
            syncComplete.onSyncComplete();
        });
    }
    public void getCats(CatListListener listener){
        syncData(() -> new Thread(() -> {
            List<Cat> catList = database.dataBaseAction().getAllCats();
            listener.onResult(catList);
        }).start());
    }
    public void getFavoriteCats(CatListListener listener){
        syncData(() -> new Thread(() -> {
            List<Cat> catList = database.dataBaseAction().getAllFavoriteCats();
            listener.onResult(catList);
        }).start());
    }
    public void getCatById(int catId, CatListener listener){
        syncData(() -> new Thread(() -> {
            Cat cat = database.dataBaseAction().getCatFromId(catId);
            listener.onResult(cat);
        }).start());
    }
    public void findCatsByName(String name, CatListListener listener){
        syncData(() -> new Thread(() -> {
            List<Cat> catList = database.dataBaseAction().findCatsByName(name);
            listener.onResult(catList);
        }).start());
    }
    public void findFavoriteCatsByName(String name, CatListListener listener){
        syncData(() -> new Thread(() -> {
            List<Cat> catList = database.dataBaseAction().findFavoriteCatsByName(name);
            listener.onResult(catList);
        }).start());
    }
    public void updateCat(Cat cat){
        database.dataBaseAction().updateCat(cat);
    }
}