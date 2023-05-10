package es2;

public class Somma extends Thread {
    private int[] array;
    private int startIndex;
    private int endIndex;
    private int sum;

    public Somma(int[] array, int startIndex, int endIndex) {
        this.array = array;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            sum += array[i];
        }
    }

    public int getSum() {
        System.out.println("Somma: " + sum);
        return sum;
    }
}
