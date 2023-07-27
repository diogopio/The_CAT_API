package com.jci.thecatapi.ui.favorites;

import androidx.databinding.Bindable;

import com.jci.thecatapi.database.CatDatabase;
import com.jci.thecatapi.model.Cat;
import com.jci.thecatapi.ui.CatListViewModel;

import java.util.List;

public class FavoritesViewModel extends CatListViewModel {

    @Bindable
    public List<Cat> getCats(){
        List<Cat> cats = CatDatabase.GetFavoriteCats();

        if (search != null) {
            List<Cat> filteredCats = CatDatabase.FindFavoritesByName(search);
            return filteredCats;
        } else {
            return cats;
        }
    }
}