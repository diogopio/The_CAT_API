package com.jci.thecatapi.ui.detail;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

import com.jci.thecatapi.model.Cat;
import com.jci.thecatapi.services.CatService;

public class DetailViewModel extends BaseObservable {
    private final CatService catService;
    private Cat cat;
    @Bindable
    public Cat getCat(){
        return cat;
    }
    public void setCat(Cat cat){
        setIsLoading(false);
        this.cat = cat;
        notifyPropertyChanged(BR.cat);
    }
    private boolean isLoading;
    @Bindable
    public boolean getIsLoading(){
        return isLoading;
    }
    public void setIsLoading(boolean isLoading){
        this.isLoading = isLoading;
        notifyPropertyChanged(BR.isLoading);
    }
    public DetailViewModel(CatService catService){
        this.catService = catService;
        setIsLoading(true);
    }
    public void toggleFavorite(){
        cat.setFavorite(!cat.isFavorite());
        new Thread(() -> catService.updateCat(cat)).start();
        notifyPropertyChanged(BR.cat);
        notifyPropertyChanged(BR.cats);
    }
    public void loadCat(int catId){
        setIsLoading(true);
        new Thread(() -> catService.getCatById(catId, this::setCat)).start();
    }
}
