package src.epicode.it.ragalzi;

// Classe per le registrazioni audio
class Registrazione extends Multimedia implements Riproducibile {
    private int durata;
    private int volume;

    public Registrazione(String titolo, int durata, int volume) {
        super(titolo);
        this.durata = durata;
        this.volume = volume;
    }

    public int getDurata() {
        return this.durata;
    }

    public void abbassaVolume() {
        if (this.volume > 0) {
            this.volume--;
        } else {
            System.out.println("Il volume è al minimo");
        }
    }

    public void alzaVolume() {
        if (this.volume < 10) {
            this.volume++;
        } else {
            System.out.println("Il volume è al massimo");
        }
    }

    public void play() {
        for (int i = 0; i < durata; i++) {
            System.out.println(this.getTitolo() + " " + "!".repeat(volume));
        }
    }

    @Override
    public String toString() {
        return "Registrazione{" +
                "titolo='" + this.getTitolo() + '\'' +
                ", durata=" + durata +
                ", volume=" + volume +
                '}';
    }
}
