package com.ragalzi;

import java.util.List;

public class Magazine extends Publication {
    private Periodicity periodicity;

    public Magazine(String title, int year, int numPages, Periodicity periodicity) {
        super(title, year, numPages);
        this.periodicity = periodicity;
    }

    public Magazine(List<String> lines) throws IllegalArgumentException, IndexOutOfBoundsException {
        super();
        if (!lines.get(0).equals("Magazine{")) {
            throw new IllegalArgumentException("Invalid line format for Magazine: " + lines);
        }
        String isbn = lines.get(1).split("=")[1].replaceAll(",", "").replaceAll("'", "");
        String title = lines.get(2).split("=")[1].replaceAll(",", "").replaceAll("'", "");
        int year = Integer.parseInt(lines.get(3).split("=")[1].replaceAll(",", "").replaceAll("'", ""));
        int numPages = Integer.parseInt(lines.get(4).split("=")[1].replaceAll(",", "").replaceAll("'", ""));
        Periodicity periodicity = Periodicity
                .valueOf(lines.get(5).split("=")[1].replaceAll(",", "").replaceAll("'", ""));
        this.setIsbn(isbn);
        this.setTitle(title);
        this.setYear(year);
        this.setNumPages(numPages);
        this.setPeriodicity(periodicity);
    }

    public Periodicity getPeriodicity() {
        return this.periodicity;
    }

    public void setPeriodicity(Periodicity periodicity) throws IllegalArgumentException {
        this.periodicity = periodicity;
    }

    @Override
    public String toString() {
        return "Magazine{\n" +
                "\tisbn='" + this.getIsbn() + '\'' +
                ",\n\ttitle='" + this.getTitle() + '\'' +
                ",\n\tyear=" + this.getYear() +
                ",\n\tnumPages=" + this.getNumPages() +
                ",\n\tperiodicity='" + this.periodicity + '\'' +
                "\n}";
    }

}
