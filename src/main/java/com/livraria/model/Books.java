package com.livraria.model;

import java.util.ArrayList;
import java.util.List;

public class Books {
    private String title;
    private String esbn;
    private int publisherId;
    private double price;
    private List<Books> bookList = new ArrayList<>();

    public Books(String title, String esbn, int publisherId, double price) {
        super();
        this.title = title;
        this.esbn = esbn;
        this.publisherId = publisherId;
        this.price = price;
    }

    // Getters
    public String getTitle() {
        return title;
    }
    public String getEsbn() {
        return esbn;
    }
    public int getPublisherId() {
        return publisherId;
    }
    public double getPrice() {
        return price;
    }
    public List<Books> getBookList() {
        return bookList;
    }

    // Setters
    public void setTitle(String title) {
        this.title = title;
    }
    public void setEsbn(String esbn) {
        this.esbn = esbn;
    }
    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setBookList(List<Books> bookList) {
        this.bookList = bookList;
    }
}