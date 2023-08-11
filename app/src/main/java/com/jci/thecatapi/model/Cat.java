package com.jci.thecatapi.model;

import androidx.annotation.NonNull;
import androidx.room.*;

import com.google.gson.Gson;

@Entity
public class Cat {

    public Cat(){

    }

    public Cat(int id, String name, String origin, int imageId, String lifeSpan, String temperament, String description){
        this.catId = id;
        this.name = name;
        this.origin = origin;
        this.imageId = imageId;
        this.lifeSpan = lifeSpan;
        this.temperament = temperament;
        this.description = description;
    }
    @PrimaryKey(autoGenerate = true)
    private int catId;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "origin")
    private String origin;
    @ColumnInfo(name = "imageId")
    private int imageId;
    @ColumnInfo(name = "favorite")
    private boolean favorite;
    @ColumnInfo(name = "lifeSpan")
    private String lifeSpan;
    @ColumnInfo(name = "temperament")
    private String temperament;
    @ColumnInfo(name = "description")
    private String description;

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getLifeSpan() {
        return lifeSpan;
    }

    public void setLifeSpan(String lifeSpan) {
        this.lifeSpan = lifeSpan;
    }

    public String getTemperament() {
        return temperament;
    }
    public void setTemperament(String temperament) { this.temperament = temperament; }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    @NonNull
    @Override
    public String toString() {
        return getName();
    }

    @Override
    public int hashCode() {
        return new Gson().toJson(this).hashCode();
    }
}
