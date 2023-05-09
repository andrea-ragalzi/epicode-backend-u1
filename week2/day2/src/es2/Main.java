package es2;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<Integer>(randomNumbers(3));
        System.out.println("Random numbers: " + numbers);
        System.out.println("Random numbers + numbers reversed " + concatInverse(numbers));
        System.out.println("Even positions: " + positionEven(numbers, true));
        System.out.println("Odd positions: " + positionEven(numbers, false));
    }

    private static List<Integer> randomNumbers(int elements) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < elements; i++) {
            numbers.add((int) (Math.random() * 100));
        }
        return numbers;
    }

    private static List<Integer> concatInverse(List<Integer> numbers) {
        List<Integer> numbersReversed = new ArrayList<>(numbers);
        Collections.reverse(numbersReversed);
        numbers.addAll(numbersReversed);
        return numbers;
    }

    private static List<Integer> positionEven(List<Integer> numbers, boolean even) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            if (i % 2 == (even ? 0 : 1)) {
                result.add(numbers.get(i));
            }
        }
        return result;
    }
}