package com.ragalzi;

import java.util.stream.IntStream;
import java.io.IOException;
import java.util.Random;

public final class App {

    public static void main(String[] args) throws IOException {
        Library library = new Library("library1.txt");
        Random rand = new Random();
        IntStream.range(1, 501)
                .forEach(i -> {
                    Publication publication = null;
                    if (i % 2 == 0) {
                        publication = new Book(
                                "Book " + i,
                                rand.nextInt(14) + 2010,
                                rand.nextInt(301) + 200,
                                "Author " + i % 5,
                                "Genre " + i);
                    } else {
                        Periodicity[] periodicities = Periodicity.values();
                        Periodicity periodicity = periodicities[rand.nextInt(
                                periodicities.length)];
                        publication = new Magazine(
                                "Magazine " + i,
                                rand.nextInt(14) + 2010,
                                rand.nextInt(301) + 200,
                                periodicity);
                    }
                    library.put(publication);
                });
        library.put(
                new Book(
                        "Book 21",
                        rand.nextInt(14) + 2010,
                        rand.nextInt(301) + 200,
                        "Author 20",
                        "Genre 20"));
        try {
            library.saveToFile(null);
            library.loadFromFile(null);
            library.saveToFile("library2.txt");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
