package models;

import java.util.List;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class Book extends Publication {

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String genre;

    public Book() {
        super();
    }

    public Book(String title, int year, int numPages, String author, String genre) {
        super(title, year, numPages);
        this.author = author;
        this.genre = genre;
    }

    public Book(String isbn, String title, int year, int numPages, String author, String genre) {
        super(title, year, numPages);
        this.isbn = isbn;
        this.author = author;
        this.genre = genre;
    }

    public Book(List<String> lines) throws IllegalArgumentException, IndexOutOfBoundsException {
        super();
        if (!lines.get(0).equals("Book{")) {
            throw new IllegalArgumentException("Invalid line format for Book: " + lines);
        }
        String isbn = lines.get(1).split("=")[1].replaceAll(",", "").replaceAll("'", "");
        String title = lines.get(2).split("=")[1].replaceAll(",", "").replaceAll("'", "");
        int year = Integer.parseInt(lines.get(3).split("=")[1].replaceAll(",", "").replaceAll("'", ""));
        int numPages = Integer.parseInt(lines.get(4).split("=")[1].replaceAll(",", "").replaceAll("'", ""));
        String author = lines.get(5).split("=")[1].replaceAll(",", "").replaceAll("'", "");
        String genre = lines.get(6).split("=")[1].replaceAll(",", "").replaceAll("'", "");
        this.setIsbn(isbn);
        this.setTitle(title);
        this.setYear(year);
        this.setNumPages(numPages);
        this.setAuthor(author);
        this.setGenre(genre);
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return this.genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book{\n" +
                "\tisbn='" + this.getIsbn() + '\'' +
                ",\n \ttitle='" + this.getTitle() + '\'' +
                ",\n \tyear=" + this.getYear() +
                ",\n \tnumPages=" + this.getNumPages() +
                ",\n \tauthor='" + this.author + '\'' +
                ",\n \tgenre='" + this.genre + '\'' +
                "\n}";
    }

    public static Book randomBook() {
        Random rand = new Random();
        String[] titles = {
                "To Kill a Mockingbird", "1984", "Animal Farm",
                "Pride and Prejudice", "The Great Gatsby",
                "The Catcher in the Rye",
                "The Lord of the Rings", "The Hobbit",
                "Harry Potter and the Philosopher's Stone",
                "The Da Vinci Code"
        };
        String title = titles[rand.nextInt(titles.length)];
        int year = rand.nextInt(14) + 2010;
        int pageCount = rand.nextInt(301) + 200;
        String[] authors = {
                "Jane Austen", "Harper Lee", "George Orwell",
                "F. Scott Fitzgerald", "J.R.R. Tolkien",
                "J.K. Rowling", "Dan Brown", "J.D. Salinger"
        };
        String author = authors[rand.nextInt(authors.length)];
        String[] genres = {
                "Romance", "Mystery", "Thriller",
                "Science Fiction", "Fantasy", "Historical Fiction"
        };
        String genre = genres[rand.nextInt(genres.length)];
        return new Book(title, year, pageCount, author, genre);
    }

}