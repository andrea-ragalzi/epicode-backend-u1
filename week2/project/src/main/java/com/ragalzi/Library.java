package com.ragalzi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class Library extends HashMap<String, Publication> {
    private int counter;
    private String filename;

    public Library(String filename) {
        counter = 0;
        this.filename = filename;
    }

    private String generateISBN() {
        return String.format("%05d", ++this.counter);
    }

    public Publication add(Publication publication) {
        publication.setIsbn(this.generateISBN());
        return super.put(publication.getIsbn(), publication);
    }

    @Override
    public Publication put(String isbn, Publication publication) {
        return super.put(isbn, publication);
    }

    @Override
    public Publication remove(Object key) {
        return super.remove(key.toString());
    }

    public Publication searchByIsbn(String isbn) {
        return this.get(isbn);
    }

    public List<Publication> getAllPublications() {
        return new ArrayList<>(values());
    }

    public List<Publication> searchByYear(int year) {
        return this.values().stream()
                .filter(publication -> publication.getYear() == year)
                .toList();
    }

    public List<Book> searchByAuthor(String author) {
        return this.values().stream()
                .filter(publication -> publication instanceof Book)
                .filter(publication -> ((Book) publication).getAuthor().equals(author))
                .map(publication -> (Book) publication)
                .toList();
    }

    public void save(String filename) throws IOException, IndexOutOfBoundsException {
        if (filename == null) {
            filename = this.filename;
        }
        FileUtils.writeStringToFile(
                new File(filename), this.toString(), "UTF-8");
    }

    public void load(String filename) throws IOException, IndexOutOfBoundsException, IllegalArgumentException {
        if (filename == null) {
            filename = this.filename;
        }
        List<String> lines = FileUtils.readLines(
                new File(filename), "UTF-8");
        List<String> tmpLines = new ArrayList<>();
        for (String line : lines) {
            if (line.startsWith("Book{")) {
                tmpLines.add(line);
            } else if (line.startsWith("Magazine{")) {
                tmpLines.add(line);
            } else if (line.equals("}")) {
                if (tmpLines.get(0).startsWith("Book{")) {
                    Book book = Book.createFromLines(tmpLines);
                    this.put(book.getIsbn(), book);
                } else if (tmpLines.get(0).startsWith("Magazine{")) {
                    Magazine magazine = Magazine.createFromLines(tmpLines);
                    this.put(magazine.getIsbn(), magazine);
                }
                tmpLines.clear();
            } else {
                tmpLines.add(line);
            }
        }
    }

    @Override
    public String toString() {
        String stringRepr = "";
        for (Publication publication : this.values()) {
            stringRepr += publication + "\n";
        }
        return stringRepr;
    }

}
