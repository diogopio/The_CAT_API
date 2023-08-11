package com.jci.thecatapi.localStorage;

import androidx.room.*;

import com.jci.thecatapi.model.Cat;

import java.util.List;

@Dao
public interface CatStore {
    @Query("SELECT * FROM Cat")
    List<Cat> getAllCats();
    @Query("DELETE FROM Cat")
    void removeAllCats();
    @Query("SELECT * FROM Cat WHERE favorite = 1")
    List<Cat> getAllFavoriteCats();
    @Query("SELECT * FROM Cat WHERE catId = :catId")
    Cat getCatFromId(int catId);
    @Query("SELECT * FROM Cat WHERE name LIKE '%'||:name||'%'")
    List<Cat> findCatsByName(String name);
    @Query("SELECT * FROM Cat WHERE favorite = 1 AND name LIKE '%'||:name||'%'")
    List<Cat> findFavoriteCatsByName(String name);
    @Insert
    void insertCat(Cat cat);
    @Update
    void updateCat(Cat cat);
    @Query("SELECT CatId FROM Cat WHERE favorite = 1")
    Integer[] getFavoriteCatsIds();
    @Query("UPDATE Cat SET favorite = 1 WHERE catId IN (:catIds)")
    void updateFavoriteCatsByIds(Integer[] catIds);
}