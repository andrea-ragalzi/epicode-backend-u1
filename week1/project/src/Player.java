import java.util.Scanner;
import java.util.InputMismatchException;

public class Player {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Multimedia[] elementi = new Multimedia[5];

        elementi[0] = new Immagine("Immagine1", 10);
        elementi[1] = new Registrazione("Registrazione1", 3, 5);
        elementi[2] = new Video("Video", 5, 8, 6);
        elementi[3] = new Immagine("Immagine2", 7);
        elementi[4] = new Registrazione("Registrazione2", 2, 3);

        int scelta = -1;

        while (scelta != 0) {
            System.out.println("\nQuale elemento vuoi eseguire? (0 per uscire)");
            for (int i = 0; i < elementi.length; i++) {
                if (elementi[i] != null) {
                    System.out.println((i + 1) + " " + elementi[i].getTitolo());
                }
            }

            try {
                scelta = input.nextInt();
                Multimedia elem = elementi[scelta - 1];

                if (elem instanceof Riproducibile) {
                    ((Riproducibile) elem).play();
                } else if (elem instanceof Immagine) {
                    ((Immagine) elem).show();
                }
            } catch (ArrayIndexOutOfBoundsException error) {
                if (scelta != 0) {
                    System.out.println("Scelta non valida");
                    input.next();
                }
            } catch (InputMismatchException error) {
                System.out.println("Scelta non valida");
                input.next();
            }
            System.out.println();
        }
        input.close();
    }
}
