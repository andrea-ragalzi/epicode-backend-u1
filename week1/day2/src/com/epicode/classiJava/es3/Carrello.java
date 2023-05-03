package src.com.epicode.classiJava.es3;

public class Carrello {
    private Cliente cliente;
    private Articolo[] articoli;
    private double totale=0;

    public Carrello(Cliente cliente, Articolo[] articoli) {
        this.cliente = cliente;
        this.articoli = articoli;
        for (Articolo articolo : this.articoli) {
            this.totale+=articolo.getPrezzo();
        }

    }

    public void stampa() {
        this.cliente.stampa();
        for (Articolo articolo : this.articoli) {
            articolo.stampa();
        }
        System.out.println("Totale: " + this.totale);
    }
}
