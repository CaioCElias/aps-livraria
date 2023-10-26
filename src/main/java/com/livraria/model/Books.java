package com.livraria.model;

public class Books {
    private String title;
    private String isbn;
    private int publisherId;
    private double price;

    // Getters
    public String getTitle() {
        return title;
    }
    
    public String getIsbn() {
        return isbn;
    }

    public int getPublisherId() {
        return publisherId;
    }

        public double getPrice() {
        return price;
    }

    // Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}