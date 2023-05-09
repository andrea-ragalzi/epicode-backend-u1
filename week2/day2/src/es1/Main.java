package es1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<String> data = new HashSet<String>();
        ArrayList<String> duplicate = new ArrayList<String>();
        Scanner scanner = new Scanner(System.in);
        int elements;
        while (true) {
            try {
                elements = scanner.nextInt();
                System.out.println("Enter " + elements + " words");
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input");
                scanner.next();
            }
        }
        while (elements-- > 0) {
            String word = scanner.next();
            if (data.contains(word)) {
                duplicate.add(word);
            }
            data.add(word);
        }
        System.out.println("Distinct words: " + data);
        System.out.println("Distinct words size: " + data.size());
        System.out.println("Duplicate words: " + duplicate);
        scanner.close();
    }
}
