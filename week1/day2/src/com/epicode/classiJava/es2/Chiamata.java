package src.com.epicode.classiJava.es2;

public class Chiamata {
    private double minuti = 0;
    private String numeroChiamato = "";

    public Chiamata(double minuti, String numeroChiamato) {
        this.minuti = minuti;
        this.numeroChiamato = numeroChiamato;
    }

    public void stampa() {
        System.out.println("Numero: " + numeroChiamato);
        System.out.println("Minuti: " + minuti);
    }
}
