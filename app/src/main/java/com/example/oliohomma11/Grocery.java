package com.example.oliohomma11;


import java.util.Date;


public class Grocery {
    private String groceryName;
    private String groceryNote;
    private Date timestamp;

    public Grocery(String groceryName, String groceryNote) {
        this.groceryName = groceryName;
        this.groceryNote = groceryNote;
        this.timestamp = new Date();
    }

    public String getGroceryName() {
        return groceryName;
    }

    public void setGroceryName(String groceryName) {
        this.groceryName = groceryName;
    }

    public String getGroceryNote() {
        return groceryNote;
    }

    public void setGroceryNote(String groceryNote) {
        this.groceryNote = groceryNote;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}





















