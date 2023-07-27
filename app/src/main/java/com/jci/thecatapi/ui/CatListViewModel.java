package com.jci.thecatapi.ui;

import android.content.Context;
import android.content.Intent;

import androidx.databinding.BaseObservable;
import androidx.databinding.library.baseAdapters.BR;

import com.jci.thecatapi.model.Cat;
import com.jci.thecatapi.ui.detail.DetailActivity;

public class CatListViewModel extends BaseObservable {
    public String search;

    public boolean Search(String text){
        search = text;
        notifyPropertyChanged(BR.cats);
        return true;
    }

    public void Selected(Context context, Cat cat){
        String a = cat.getName();
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra("id", cat.getId());
        context.startActivity(intent);
    }
}
