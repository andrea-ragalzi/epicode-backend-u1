package src.com.epicode.classiJava.es3;

public class Cliente {
    private String nome = "";
    private String cognome = "";
    private String email = "";
    private String codice = "";
    private String dataIscrizione = "";

    public Cliente(String nome, String cognome, String email, String codice, String dataIscrizione) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.codice = codice;
        this.dataIscrizione = dataIscrizione;
    }

    public void stampa() {
        System.out.println("Nome: " + nome);
        System.out.println("Cognome: " + cognome);
        System.out.println("Email: " + email);
        System.out.println("Codice: " + codice);
        System.out.println("Data di iscrizione: " + dataIscrizione);
    }
}
