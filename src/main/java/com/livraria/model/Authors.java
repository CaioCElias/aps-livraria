package com.livraria.model;

public class Authors {
    private int authorId;
    private String name;
    private String fName;

    public Authors(int authorId, String name, String fName) {
        this.authorId = authorId;
        this.name = name;
        this.fName = fName;
    }

    // Getters
    public int getAuthorId() {
        return authorId;
    }

    public String getName() {
        return name;
    }

    public String getFName() {
        return fName;
    }

    // Setters
    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }
}
