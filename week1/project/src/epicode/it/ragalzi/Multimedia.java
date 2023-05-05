package src.epicode.it.ragalzi;

abstract class Multimedia {
    protected String titolo;

    public Multimedia(String titolo) {
        this.titolo = titolo;
    }

    public String getTitolo() {
        return titolo;
    }

    @Override
    public String toString() {
        return "Multimedia{" +
                "titolo='" + titolo + '\'' +
                '}';
    }
}