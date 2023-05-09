import java.util.InputMismatchException;
import java.util.Scanner;

public class Es2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Inserisci i km percorsi: ");
            float kilometri = scanner.nextInt();
            System.out.print("Inserisci il numero di litri: ");
            float litriCarburante = scanner.nextInt();
            if (litriCarburante == 0) {
                System.out.println("Il numero di litri deve essere maggiore di zero.");
            } else {
                System.out.println("Hai percorso: " + kilometri / litriCarburante + " km/litro");
            }
        } catch (InputMismatchException error) {
            System.out.println(error);
            scanner.next();
        }
        scanner.close();
    }
}
