package com.example.oliohomma11;


import java.util.Date;

public class Grocery {
    private final String GroceryName;
    private final String GroceryNote;
    private final Date timestamp;

    public Grocery(String groceryName, String groceryNote) {
        this.GroceryName = groceryName;
        this.GroceryNote = groceryNote;
        this.timestamp = new Date();
    }

    public String getGroceryName() {
        return GroceryName;
    }

    public String getGroceryNote() {
        return GroceryNote;
    }

    public Date getTimestamp() {
        return timestamp;
    }
}



