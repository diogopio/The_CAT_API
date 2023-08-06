package com.jci.thecatapi.services;

import com.jci.thecatapi.database.CatDatabase;
import com.jci.thecatapi.model.Cat;

import java.util.List;

public class CatService {
    public interface CatListListener { void onResult(List<Cat> result); }
    public interface CatListener { void onResult(Cat result); }
    private final CatDatabase database;
    public CatService(CatDatabase database){
        this.database = database;
    }
    public void getCats(CatListListener listener){
        List<Cat> catList = database.dataBaseAction().getAllCats();
        listener.onResult(catList);
    }
    public void getFavoriteCats(CatListListener listener){
        List<Cat> catList = database.dataBaseAction().getAllFavoriteCats();
        listener.onResult(catList);
    }
    public void getCatById(int id, CatListener listener){
        Cat cat = database.dataBaseAction().getCatFromId(id);
        listener.onResult(cat);
    }
    public void findCatsByName(String name, CatListListener listener){
        List<Cat> catList = database.dataBaseAction().findCatsByName(name);
        listener.onResult(catList);
    }
    public void findFavoriteCatsByName(String name, CatListListener listener){
        List<Cat> catList = database.dataBaseAction().findFavoriteCatsByName(name);
        listener.onResult(catList);
    }
    public void updateCat(Cat cat){
        database.dataBaseAction().updateCat(cat);
    }
}
