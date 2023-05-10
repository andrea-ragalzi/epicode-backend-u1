package es3;

public class Presenza {
    private String nomeDipendente;
    private int numeroPresenze;

    public Presenza(String nomeDipendente) {
        this.nomeDipendente = nomeDipendente;
        this.numeroPresenze = 0;
    }

    public Presenza(String nomeDipendente, int numeroPresenze) {
        this.nomeDipendente = nomeDipendente;
        this.numeroPresenze = numeroPresenze;
    }

    public String getNomeDipendente() {
        return this.nomeDipendente;
    }

    public int getNumeroPresenze() {
        return this.numeroPresenze;
    }

    public void incrementa() {
        this.numeroPresenze++;
    }

    @Override
    public String toString() {
        return this.nomeDipendente + "@" + this.numeroPresenze;
    }
}
