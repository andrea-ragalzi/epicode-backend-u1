import java.util.Scanner;

public class Es4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Inserisci un intero: ");
            String userInput = scanner.nextLine();
            if (userInput.equals(":q")) {
                scanner.close();
                break;
            }
            try {
                int num = Integer.parseInt(userInput);
                System.out.println("Hai inserito il numero " + num);
                for (int i = num; i >= 0; i--) {
                    System.out.println(i);
                }
            } catch (NumberFormatException e) {
                System.out.println("Inserisci un numero valido!");
                continue;
            }
        }
    }
}
