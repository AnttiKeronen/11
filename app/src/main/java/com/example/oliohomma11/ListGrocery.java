package com.example.oliohomma11;

import java.util.ArrayList;
import java.util.List;

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



    public void removeGrocery(String name) {
        for (int i = 0; i < groceryList.size(); i++) {
            if (groceryList.get(i).getName().equals(name)) {
                groceryList.remove(i);
                return;
            }
        }
    }

    public void updateGrocery(Grocery updatedGrocery) {
        for (int i = 0; i < groceryList.size(); i++) {
            if (groceryList.get(i).getName().equals(updatedGrocery.getName())) {
                groceryList.set(i, updatedGrocery);
                return;
            }
        }
    }

    public List<Grocery> getGroceryList() {
        return groceryList;
    }
}















































