package com.jci.thecatapi.database;

import androidx.room.*;

import com.jci.thecatapi.model.Cat;

import java.util.List;

@Dao
public interface CatStore {
    @Query("SELECT * FROM Cat")
    List<Cat> getAllCats();
    @Query("SELECT * FROM Cat WHERE favorite = 1")
    List<Cat> getAllFavoriteCats();
    @Query("SELECT * FROM Cat WHERE catId = :catId")
    Cat getCatFromId(int catId);
    @Query("SELECT * FROM Cat WHERE name LIKE '%'||:name||'%'")
    List<Cat> findCatsByName(String name);
    @Query("SELECT * FROM Cat WHERE favorite = 1 AND name LIKE '%'||:name||'%'")
    List<Cat> findFavoriteCatsByName(String name);
    @Update
    void updateCat(Cat cat);
}