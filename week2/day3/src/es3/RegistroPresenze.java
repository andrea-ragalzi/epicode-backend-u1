package es3;

public class RegistroPresenze {
    Presenza[] presenze;

    public RegistroPresenze() {
        this.presenze = new Presenza[presenze.length];
    }

    public RegistroPresenze(Presenza[] presenze) {
        this.presenze = presenze;
    }

    public Presenza[] getPresenze() {
        return this.presenze;
    }

    @Override
    public String toString() {
        for(Presenza presenza : presenze) {
            System.out.println(presenza);
        }
        return "";
    }
}
