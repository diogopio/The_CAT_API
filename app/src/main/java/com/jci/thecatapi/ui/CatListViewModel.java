package com.jci.thecatapi.ui;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

import com.jci.thecatapi.model.Cat;
import com.jci.thecatapi.services.CatService;

import java.util.List;

public abstract class CatListViewModel extends BaseObservable {
    protected CatService catService;
    private String search;
    @Bindable
    public String getSearch() { return search; }
    public void setSearch(String text){
        search = text;
        notifyPropertyChanged(BR.search);
    }
    private List<Cat> cats;
    @Bindable
    public List<Cat> getCats() {
        return cats;
    }
    protected void setCats(List<Cat> catList){
        this.cats = catList;
        notifyPropertyChanged(BR.cats);
        setIsLoading(false);
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
    public abstract void loadCats();
    public CatListViewModel(CatService catService){
        this.catService = catService;
        setIsLoading(true);
    }
    public boolean search(String text){
        setSearch(text);
        return true;
    }
}
