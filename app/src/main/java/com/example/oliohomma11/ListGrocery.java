package com.example.oliohomma11;

import java.util.ArrayList;

import java.util.List;

public class ListGrocery {
    private static ListGrocery instance;
    private final List<Grocery> groceryList;

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

    public Grocery getGroceryByName(String name) {
        for (Grocery grocery : groceryList) {
            if (grocery.getGroceryName().equals(name)) {
                return grocery;
            }
        }
        return null;
    }


    public List<Grocery> getGroceries() {
        return groceryList;
    }


}














































