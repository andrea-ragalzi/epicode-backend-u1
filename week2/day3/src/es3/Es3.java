package es3;

import java.io.IOException;

public class Es3 {
    public static void main(String[] args) throws IOException {
        Presenza[] presenze = new Presenza[3];
        // presenze[0] = new Presenza("Pippo", 4);
        // presenze[1] = new Presenza("Pluto", 190);
        // presenze[2] = new Presenza("Gigi", 33);
        RegistroPresenze registroPresenze = new RegistroPresenze(presenze);
        System.out.println(registroPresenze);
        // registroPresenze.salvaPresenze();
        registroPresenze.leggiPresenze();
        System.out.println(registroPresenze);
    }
}
