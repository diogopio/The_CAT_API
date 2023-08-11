package com.jci.thecatapi.localStorage;

import android.content.Context;
import androidx.room.Room;

public class DatabaseClient {
    public static long syncAgeInMillis;
    private static DatabaseClient mInstance;
    private final CatDatabase appDatabase;
    private DatabaseClient(Context context) {
        appDatabase = Room.databaseBuilder(context, CatDatabase.class, "Cat.db")
                .fallbackToDestructiveMigration()
                .build();
    }
    public static synchronized DatabaseClient getInstance(Context mCtx) {
        if (mInstance == null) {
            mInstance = new DatabaseClient(mCtx);
        }
        return mInstance;
    }
    public CatDatabase getAppDatabase() {
        return appDatabase;
    }
}