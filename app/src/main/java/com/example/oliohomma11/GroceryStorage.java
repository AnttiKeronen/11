package com.example.oliohomma11;

import java.util.List;
import java.util.ArrayList;

public class GroceryStorage {
    private static GroceryStorage instance;
    private List<Grocery> groceryList;

    private GroceryStorage() {
        groceryList = new ArrayList<>();
    }

    public static synchronized GroceryStorage getInstance() {
        if (instance == null) {
            instance = new GroceryStorage();
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

