package src.com.epicode.classiJava.es1;

public class Main {
    public static void main(String[] args) {
        Rettangolo rettangolo1 = new Rettangolo(4.0, 3.0);
        Rettangolo rettangolo2 = new Rettangolo(2.0, 12.0);
        Rettangolo rettangolo3 = new Rettangolo(40.0, 30.0);
        Rettangolo[] rettangoli = { rettangolo1, rettangolo2, rettangolo3 };
        Rettangolo.stampaRettangoli(rettangoli);
    }
}