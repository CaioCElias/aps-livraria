package com.livraria.model;

public class Publishers {
    private int publisherId;
    private String name;
    private String url;

    public Publishers(int publisherId, String name, String url) {
        this.publisherId = publisherId;
        this.name = name;
        this.url = url;
    }

    // Getters
    public int getPublisherId() {
        return publisherId;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    // Setters
    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
