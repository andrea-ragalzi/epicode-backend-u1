package src.epicode.it.ragalzi;

// Classe per le immagini
class Immagine extends Multimedia implements Luminosita {
    private int luminosita;

    public Immagine(String titolo, int luminosita) {
        super(titolo);
        this.luminosita = luminosita;
    }

    public void abbassaLuminosita() {
        if (this.luminosita > 0) {
            this.luminosita--;
        } else {
            System.out.println("La luminosità è al minimo");
        }
    }

    public void alzaLuminosita() {
        if (this.luminosita < 100) {
            this.luminosita++;
        } else {
            System.out.println("La luminosità è al massimo");
        }
    }

    public void show() {
        System.out.println(getTitolo() + " " + "*".repeat(luminosita));
    }

    @Override
    public String toString() {
        return "Immagine{" +
                "titolo='" + getTitolo() + '\'' +
                ", luminosita=" + luminosita +
                '}';
    }
}