package com.ragalzi;

public abstract class Publication {
    protected String isbn;
    private String title;
    private int year;
    private int numPages;

    public Publication() {
        this.isbn = null;
        this.title = null;
        this.year = 0;
        this.numPages = 0;
    }

    public Publication(String title, int year, int numPages) {
        this.isbn = null;
        this.title = title;
        this.year = year;
        this.numPages = numPages;
    }

    public String getIsbn() {
        return this.isbn;
    }

    protected void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return this.title;
    }

    protected void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return this.year;
    }

    protected void setYear(int year) {
        this.year = year;
    }

    public int getNumPages() {
        return this.numPages;
    }

    protected void setNumPages(int numPages) {
        this.numPages = numPages;
    }
}
