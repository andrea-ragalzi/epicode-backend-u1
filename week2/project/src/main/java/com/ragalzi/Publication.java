package com.ragalzi;

public abstract class Publication {
    protected String isbn;
    private String title;
    private int year;
    private int numPages;

    // constructor
    public Publication(String title, int year, int numPages) {
        this.isbn = null;
        this.title = title;
        this.year = year;
        this.numPages = numPages;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return this.title;
    }

    public int getYear() {
        return this.year;
    }

    public int getNumPages() {
        return this.numPages;
    }
}
