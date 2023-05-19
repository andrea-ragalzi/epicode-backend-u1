package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Library extends HashMap<String, Publication> {

    private String generateISBN() {
        return String.format("%05d", this.values().size() + 1);
    }

    public Publication put(Publication publication) {
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

    @Override
    public String toString() {
        String stringRepr = "";
        for (Publication publication : this.values()) {
            stringRepr += publication + "\n";
        }
        return stringRepr;
    }

    public static Library randomLibrary(int quantity) {
        Library library = new Library();
        Random rand = new Random();
        for (int i = 0; i < quantity; i++) {
            if (rand.nextBoolean()) {
                Book book = Book.randomBook();
                library.put(book);
            } else {
                Magazine magazine = Magazine.randomMagazine();
                library.put(magazine);
            }
        }
        return library;
    }
}
