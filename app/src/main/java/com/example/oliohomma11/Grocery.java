package com.example.oliohomma11;

import java.util.Date;

public class Grocery {
    private String name;
    private String note;
    private Date timestamp;

    public Grocery(String name, String note) {
        this.name = name;
        this.note = note;
        this.timestamp = new Date();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
























