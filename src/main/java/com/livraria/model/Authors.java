package com.livraria.model;

public class Authors {
    private int authorId;
    private String name;
    private String fName;

    // Getters
    public int authorId() {
        return authorId;
    }

    public String name() {
        return name;
    }

    public String fName() {
        return fName;
    }

    // Setters
    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void getFName(String fName) {
        this.fName = fName;
    }
}
