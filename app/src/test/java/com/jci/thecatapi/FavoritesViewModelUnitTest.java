package com.jci.thecatapi;

import static org.junit.Assert.assertEquals;

import com.jci.thecatapi.database.CatDatabase;
import com.jci.thecatapi.model.Cat;
import com.jci.thecatapi.ui.favorites.FavoritesViewModel;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

public class FavoritesViewModelUnitTest {

    private static final List<Cat> cats = new ArrayList<>();

    @Mock
    private static FavoritesViewModel favoritesViewModel;

    @BeforeClass
    public static void Setup(){
        cats.add(new Cat(1,"Cat 1", "Portugal", 0, "", "", ""));
        cats.add(new Cat(2,"Cat 2", "Spain", 0, "", "", ""));
        cats.add(new Cat(3,"Cat 3", "United States", 0, "", "", ""));
        cats.add(new Cat(4,"Lion", "Africa", 0, "", "", ""));
        cats.get(0).setFavorite(true);
        cats.get(3).setFavorite(true);
        CatDatabase.SetCats(cats);

        favoritesViewModel = new FavoritesViewModel();
    }

    @Test
    public void getCats_isCorrect() {
        assertEquals(favoritesViewModel.getCats().size(), 2);
    }

    @Test
    public void getFilteredCats_isCorrect() {
        favoritesViewModel.Search("lion");
        assertEquals(favoritesViewModel.getCats().size(), 1);
    }

    @Test
    public void clearFilteredCats_isCorrect() {
        favoritesViewModel.Search("cat");
        assertEquals(favoritesViewModel.getCats().size(), 1);

        favoritesViewModel.Search(null);
        assertEquals(favoritesViewModel.getCats().size(), 2);
    }
}
