import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Es1 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        int[] numbers = randomNumbers(5);
        int input = -1;
        printNumbers(numbers);
        do {
            try {
                System.out.print("Enter a number: ");
                input = scanner.nextInt();
                if (input == 0) {
                    continue;
                }
                numbers[input - 1] = rand.nextInt(10) + 1;
                printNumbers(numbers);
            } catch (InputMismatchException error) {
                System.out.println("Error: " + error);
                scanner.next();
            } catch (ArrayIndexOutOfBoundsException error) {
                System.out.println("Error: " + error);
                scanner.next();
            } catch (Exception error) {
                System.out.println("Error: " + error);
                scanner.next();
            }
        } while (input != 0);
        scanner.close();
    }

    private static int[] randomNumbers(int length) {
        int[] numbers = new int[length];
        Random rand = new Random(System.currentTimeMillis());
        for (int i = 0; i < length; i++) {
            numbers[i] = rand.nextInt(10) + 1;
        }
        return numbers;
    }

    private static void printNumbers(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
    }
}
