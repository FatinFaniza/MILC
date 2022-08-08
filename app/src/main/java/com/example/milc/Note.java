package com.example.milc;

public class Note {

    String itemId;
    String title;
    String description;

    public Note() {
    }

    public Note(String itemId, String title, String description) {
        this.itemId = itemId;
        this.title = title;
        this.description = description;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}



