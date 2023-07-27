package com.jci.thecatapi.ui.detail;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

import com.jci.thecatapi.model.Cat;

public class DetailViewModel extends BaseObservable {
    public DetailViewModel(Cat cat){
        this.cat = cat;
    }

    @Bindable
    public Cat cat;

    public void toggleFavorite(){
        cat.setFavorite(!cat.isFavorite());
        notifyPropertyChanged(BR.cat);
        notifyPropertyChanged(BR.cats);
    }
}
