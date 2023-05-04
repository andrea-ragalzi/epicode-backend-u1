import java.util.Scanner;

public class Es3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Inserisci una stringa: ");
            String userInput = scanner.nextLine();
            if(userInput.equals(":q")){
                scanner.close();
                break;
            }
            for (int i = 0; i < userInput.length(); i++) {
                if(i!=0){
                    System.out.print(", ");
                }
                System.out.print(userInput.charAt(i));
            }
            System.out.println();
        }
    }
}
