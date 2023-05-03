package src.com.epicode.classiJava.es2;

public class Sim {
    private String numero;
    private double credito;
    private Chiamata[] registro;

    public Sim(String numero) {
        this.numero = numero;
        this.credito = 0;
        this.registro = new Chiamata[5];
    }

    public void aggiungiChiamata(Chiamata chiamata) {
        int i;
        for (i = 1; i < this.registro.length; i++) {
            this.registro[i - 1] = this.registro[i];
        }
        this.registro[i - 1] = chiamata;
    }

    public void stampa() {
        System.out.println("Numero: " + numero);
        System.out.println("Credito: " + credito);
        for (int i = 0; i < registro.length; i++) {
            if (registro[i] == null) {
                break;
            }
            registro[i].stampa();
        }
    }
}
