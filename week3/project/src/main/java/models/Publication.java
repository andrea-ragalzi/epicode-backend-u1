package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.persistence.InheritanceType;

@Entity
@Table(name = "publications")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Publication {

    @Id
    protected String isbn;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private int year;

    @Column(nullable = false)
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

    public void setIsbn(String isbn) {
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
