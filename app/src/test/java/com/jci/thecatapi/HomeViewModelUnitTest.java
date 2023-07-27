package com.jci.thecatapi;

import static org.junit.Assert.assertEquals;

import com.jci.thecatapi.database.CatDatabase;
import com.jci.thecatapi.model.Cat;
import com.jci.thecatapi.ui.home.HomeViewModel;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

public class HomeViewModelUnitTest {

    private static final List<Cat> cats = new ArrayList<>();

    @Mock
    private static HomeViewModel homeViewModel;

    @BeforeClass
    public static void Setup(){
        cats.add(new Cat(1,"Cat 1", "Portugal", 0, "", "", ""));
        cats.add(new Cat(2,"Cat 2", "Spain", 0, "", "", ""));
        cats.add(new Cat(3,"Cat 3", "United States", 0, "", "", ""));
        cats.add(new Cat(4,"Lion", "Africa", 0, "", "", ""));
        cats.get(0).setFavorite(true);
        CatDatabase.SetCats(cats);

        homeViewModel = new HomeViewModel();
    }

    @Test
    public void getCats_isCorrect() {
        assertEquals(homeViewModel.getCats().size(), 4);
    }

    @Test
    public void getFilteredCats_isCorrect() {
        homeViewModel.Search("lion");
        assertEquals(homeViewModel.getCats().size(), 1);
    }

    @Test
    public void clearFilteredCats_isCorrect() {
        homeViewModel.Search("cat");
        assertEquals(homeViewModel.getCats().size(), 3);

        homeViewModel.Search(null);
        assertEquals(homeViewModel.getCats().size(), 4);
    }
}
