package es2;

import java.util.Random;

public class Es2 {
    public static void main(String[] args) throws InterruptedException {
        int workers = 3;
        int[] array = new int[3000];
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10);
        }

        int blockSize = 3000 / workers;
        Somma[] threads = new Somma[workers];

        for (int i = 0; i < threads.length; i++) {
            int startIndex = i * blockSize;
            int endIndex = (i + 1) * blockSize;
            threads[i] = new Somma(array, startIndex, endIndex);
            threads[i].start();
        }

        for (Somma thread : threads) {
            thread.join();
        }

        int totalSum = 0;

        for (Somma thread : threads) {
            totalSum += thread.getSum();
        }

        System.out.println("La somma totale è: " + totalSum);
    }
}
