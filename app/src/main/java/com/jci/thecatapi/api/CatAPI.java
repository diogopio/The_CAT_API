package com.jci.thecatapi.api;

import com.jci.thecatapi.model.Cat;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CatAPI {
    @GET("cats")
    Call<List<Cat>> getCats();
}