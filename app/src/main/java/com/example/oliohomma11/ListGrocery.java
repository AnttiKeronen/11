package com.example.oliohomma11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListGrocery {
    private static ListGrocery instance;
    private List<Grocery> groceries;

    private ListGrocery() {
        groceries = new ArrayList<>();
    }

    public static synchronized ListGrocery getInstance() {
        if (instance == null) {
            instance = new ListGrocery();
        }
        return instance;
    }

    public void addGrocery(Grocery grocery) {
        groceries.add(grocery);
    }

    public Grocery getGroceryByName(String name) {
        for (Grocery grocery : groceries) {
            if (grocery.getGroceryName().equals(name)) {
                return grocery;
            }
        }
        return null;
    }

    public void removeGrocery(String name) {
        Grocery groceryToRemove = getGroceryByName(name);
        if (groceryToRemove != null) {
            groceries.remove(groceryToRemove);
        }
    }

    public List<Grocery> getGroceries() {
        return groceries;
    }

    public void sortGroceriesByAlphabet() {
        Collections.sort(groceries, new Comparator<Grocery>() {
            @Override
            public int compare(Grocery grocery1, Grocery grocery2) {
                return grocery1.getGroceryName().compareToIgnoreCase(grocery2.getGroceryName());
            }
        });
    }

    public void sortGroceriesByTime() {
        Collections.sort(groceries, new Comparator<Grocery>() {
            @Override
            public int compare(Grocery grocery1, Grocery grocery2) {
                return grocery2.getTimestamp().compareTo(grocery1.getTimestamp());
            }
        });
    }
}






