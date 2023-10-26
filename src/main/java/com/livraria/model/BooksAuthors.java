package com.livraria.model;

public class BooksAuthors {
    private String isbn;
    private int authorId;
    private int seqNo;

    // Getters
    public String getIsbn() {
        return isbn;
    }

    public int getAuthotId() {
        return authorId;
    }

    public int getSeqNo() {
        return seqNo;
    }

    // Setters
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public void setSeqNo(int seqNo) {
        this.seqNo = seqNo;
    }
}
