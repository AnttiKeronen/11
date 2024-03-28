package com.example.oliohomma11;

import java.util.List;
import java.util.ArrayList;

public class ListGrocery {
    private static ListGrocery instance;
    private List<Grocery> groceryList;

    private ListGrocery() {
        groceryList = new ArrayList<>();
    }

    public static synchronized ListGrocery getInstance() {
        if (instance == null) {
            instance = new ListGrocery();
        }
        return instance;
    }

    public void addGrocery(Grocery grocery) {
        groceryList.add(grocery);
    }

    public List<Grocery> getGroceries() {
        return groceryList;
    }
}













































