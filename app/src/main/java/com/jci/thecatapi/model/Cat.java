package com.jci.thecatapi.model;

import androidx.annotation.NonNull;

public class Cat {
    public Cat(int id, String name, String origin, int imageId, String lifeSpan, String temperament, String description){
        this.id = id;
        this.name = name;
        this.origin = origin;
        this.imageId = imageId;
        this.lifeSpan = lifeSpan;
        this.temperament = temperament;
        this.description = description;
    }

    private int id;
    private String name;
    private String origin;
    private int imageId;
    private boolean favorite;
    private String lifeSpan;
    private String temperament;
    private String description;

    public String getLifeSpan() {
        return lifeSpan;
    }

    public void setLifeSpan(String lifeSpan) {
        this.lifeSpan = lifeSpan;
    }

    public String getTemperament() {
        return temperament;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

}
