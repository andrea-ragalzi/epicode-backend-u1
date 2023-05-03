package src.com.epicode.classiJava.es1;

public class Rettangolo {
    private double base;
    private double altezza;

    public Rettangolo(double base, double altezza) {
        this.base = base;
        this.altezza = altezza;
    }

    private double Area() {
        return this.base * this.altezza;
    }

    private double Perimetro() {
        return this.base * 2 + this.altezza * 2;
    }

    private static double sommaArea(Rettangolo[] rettangoli) {
        double somma = 0;
        for (Rettangolo rettangolo : rettangoli) {
            somma += rettangolo.Area();
        }
        return somma;
    }

    private static double sommaPerimetri(Rettangolo[] rettangoli) {
        double somma = 0;
        for (Rettangolo rettangolo : rettangoli) {
            somma += rettangolo.Perimetro();
        }
        return somma;
    }

    public static void stampaRettangolo(Rettangolo rettangolo) {
        System.out.println("Perimetro: " + rettangolo.Perimetro());
        System.out.println("Area: " + rettangolo.Area());
    }

    public static void stampaRettangoli(Rettangolo[] rettangoli) {
        for (Rettangolo rettangolo : rettangoli) {
            stampaRettangolo(rettangolo);
        }
        System.out.println("Somma perimetri: " + sommaPerimetri(rettangoli));
        System.out.println("Somma area: " + sommaArea(rettangoli));
    }
}
