package com.jci.thecatapi.ui.home;

import com.jci.thecatapi.services.CatService;
import com.jci.thecatapi.ui.CatListViewModel;

public class HomeViewModel extends CatListViewModel {
    public HomeViewModel(CatService catService) {
        super(catService);
    }
    CatService.CatListListener catListListener = this::setCats;
    @Override
    public void loadCats(){
        setIsLoading(true);
        String search = getSearch();
        if (search != null && search.length() > 0) {
            new Thread(() -> catService.findCatsByName(search, catListListener)).start();
        } else {
            new Thread(() -> catService.getCats(catListListener)).start();
        }
    }
}