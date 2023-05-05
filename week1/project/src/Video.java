class Video extends Multimedia implements Riproducibile, Volume, Luminosita {
    private int durata;
    private int volume;
    private int luminosita;

    public Video(String titolo, int durata, int volume, int luminosita) {
        super(titolo);
        this.durata = durata;
        this.volume = volume;
        this.luminosita = luminosita;
    }

    public int getDurata() {
        return durata;
    }

    public void alzaLuminosita() {
        if (luminosita < 100) {
            luminosita++;
        } else {
            System.out.println("La luminosita è al massimo");
        }
    }

    public void abbassaLuminosita() {
        if (luminosita > 0) {
            luminosita--;
        } else {
            System.out.println("La luminosita è al massimo");
        }
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
            System.out.println(getTitolo() + " " + "!".repeat(volume) + " *".repeat(luminosita));
        }
    }

    @Override
    public String toString() {
        return "Video{" +
                "titolo='" + getTitolo() + '\'' +
                ", durata=" + durata +
                ", volume=" + volume +
                ", luminosita=" + luminosita +
                '}';
    }
}