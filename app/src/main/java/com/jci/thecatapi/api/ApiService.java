package com.jci.thecatapi.api;

import androidx.annotation.NonNull;

import com.jci.thecatapi.model.Cat;
import com.jci.thecatapi.services.CatService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {
    private final CatAPI catAPI;

    public ApiService(){
        catAPI = new Retrofit.Builder()
                .baseUrl("https://64d3e28a67b2662bf3dcd60f.mockapi.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(CatAPI.class);
    }

    public void getCats(CatService.CatListListener catListListener){
        catAPI.getCats().enqueue(new Callback<List<Cat>>() {
            @Override
            public void onResponse(@NonNull Call<List<Cat>> call, @NonNull Response<List<Cat>> response) {
                if (response.isSuccessful()) {
                    List<Cat> cats = response.body();
                    catListListener.onResult(cats);
                } else {
                    catListListener.onResult(null);
                }
            }
            @Override
            public void onFailure(@NonNull Call<List<Cat>> call, @NonNull Throwable t) {
                catListListener.onResult(null);
            }
        });
    }
}
