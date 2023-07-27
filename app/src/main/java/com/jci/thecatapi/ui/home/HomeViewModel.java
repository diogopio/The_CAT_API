package com.jci.thecatapi.ui.home;

import androidx.databinding.Bindable;

import com.jci.thecatapi.database.CatDatabase;
import com.jci.thecatapi.model.Cat;
import com.jci.thecatapi.ui.CatListViewModel;

import java.util.List;

public class HomeViewModel extends CatListViewModel {

    @Bindable
    public List<Cat> getCats() {
        List<Cat> cats = CatDatabase.GetCats();

        if (search != null) {
            List<Cat> filteredCats = CatDatabase.FindByName(search);
            return filteredCats;
        } else {
            return cats;
        }
    }

}