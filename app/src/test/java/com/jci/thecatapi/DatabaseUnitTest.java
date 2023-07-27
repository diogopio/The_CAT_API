package com.jci.thecatapi;

import static org.junit.Assert.assertEquals;

import com.jci.thecatapi.database.CatDatabase;
import com.jci.thecatapi.model.Cat;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class DatabaseUnitTest {

    private static final List<Cat> cats = new ArrayList<>();

    @BeforeClass
    public static void Setup(){
        cats.add(new Cat(1,"Cat 1", "Portugal", 0, "", "", ""));
        cats.add(new Cat(2,"Cat 2", "Spain", 0, "", "", ""));
        cats.add(new Cat(3,"Cat 3", "United States", 0, "", "", ""));
        cats.add(new Cat(4,"Lion", "Africa", 0, "", "", ""));
        cats.get(0).setFavorite(true);
        CatDatabase.SetCats(cats);
    }

    @Test
    public void getAllCats_Size_isCorrect() {
        assertEquals(CatDatabase.GetCats().size(), 4);
    }
    @Test
    public void getAllFavoriteCats_Size_isCorrect() {
        assertEquals(CatDatabase.GetFavoriteCats().size(), 1);
    }

    @Test
    public void FindByName_Size_isCorrect() {
        assertEquals(CatDatabase.FindByName("1").size(), 1);
    }

    @Test
    public void FindByName_CaseSensitive_isCorrect() {
        assertEquals(CatDatabase.FindByName("cat").size(), 3);
    }

    @Test
    public void FindFavoriteByName_1Result_isCorrect() {
        assertEquals(CatDatabase.FindFavoritesByName("cat").size(), 1);
    }

    @Test
    public void FindFavoriteByName_NoResult_isCorrect() {
        assertEquals(CatDatabase.FindFavoritesByName("lion").size(), 0);
    }
}