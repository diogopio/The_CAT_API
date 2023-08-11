package com.jci.thecatapi.localStorage;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.jci.thecatapi.model.Cat;

@Database(entities = {Cat.class}, version = 2, exportSchema = false)
public abstract class CatDatabase extends RoomDatabase {
    public abstract CatStore dataBaseAction();
}

