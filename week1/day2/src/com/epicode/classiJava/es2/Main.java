package src.com.epicode.classiJava.es2;

public class Main {
    public static void main(String[] args) {
        Sim sim = new Sim("123456789");
        sim.aggiungiChiamata(new Chiamata(5.5, "0"));
        sim.aggiungiChiamata(new Chiamata(5.5, "1"));
        sim.aggiungiChiamata(new Chiamata(5.5, "2"));
        sim.aggiungiChiamata(new Chiamata(5.5, "3"));
        sim.aggiungiChiamata(new Chiamata(5.5, "4"));
        sim.aggiungiChiamata(new Chiamata(5.5, "5"));
        sim.aggiungiChiamata(new Chiamata(5.5, "6"));
        sim.stampa();
    }
}