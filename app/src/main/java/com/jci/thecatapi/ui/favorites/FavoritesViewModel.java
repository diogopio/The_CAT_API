package com.jci.thecatapi.ui.favorites;

import com.jci.thecatapi.services.CatService;
import com.jci.thecatapi.ui.CatListViewModel;

public class FavoritesViewModel extends CatListViewModel {
    public FavoritesViewModel(CatService catService) {
        super(catService);
    }
    CatService.CatListListener catListListener = this::setCats;
    @Override
    public void loadCats(){
        String search = getSearch();
        if (search != null && search.length() > 0) {
            new Thread(() -> catService.findFavoriteCatsByName(search, catListListener)).start();
        } else {
            new Thread(() -> catService.getFavoriteCats(catListListener)).start();
        }
    }
}