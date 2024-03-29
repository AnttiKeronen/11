package com.example.oliohomma11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

    public List<Grocery> getGroceries() {
        return groceryList;
    }

    public void sortGroceriesByAlphabet() {
        Collections.sort(groceryList, new Comparator<Grocery>() {
            @Override
            public int compare(Grocery grocery1, Grocery grocery2) {
                return grocery1.getName().compareToIgnoreCase(grocery2.getName());
            }
        });
    }

    public void sortGroceriesByTime() {
        Collections.sort(groceryList, new Comparator<Grocery>() {
            @Override
            public int compare(Grocery grocery1, Grocery grocery2) {
                return grocery1.getTimestamp().compareTo(grocery2.getTimestamp());
            }
        });
    }

    public Grocery getGroceryByName(String name) {
        for (Grocery grocery : groceryList) {
            if (grocery.getName().equals(name)) {
                return grocery;
            }
        }
        return null;
    }

}


















































