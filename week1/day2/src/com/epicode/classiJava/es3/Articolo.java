package src.com.epicode.classiJava.es3;

public class Articolo {
    private String codice="";
    private String descrizione="";
    private double prezzo=0;
    private int quantita=0;

    public Articolo(String codice, String descrizione, double prezzo, int quantita) {
        this.codice = codice;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
    }

    public double getPrezzo() {
        return this.prezzo;
    }

    public void stampa() {
        System.out.println("Codice: " + codice);
        System.out.println("Descrizione: " + descrizione);
        System.out.println("Prezzo: " + prezzo);
        System.out.println("Quantità: " + quantita);
    }
}
