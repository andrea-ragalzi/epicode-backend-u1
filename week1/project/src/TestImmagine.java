public class TestImmagine {
    public static void main(String[] args) {
        Immagine immagine = new Immagine("Venere", 50);
        System.out.println(immagine);
        immagine.show();
        for (int i = 0; i < 55; i++) {
            immagine.alzaLuminosita();
        }
        System.out.println(immagine);
        immagine.show();
        for (int i = 0; i < 105; i++) {
            immagine.abbassaLuminosita();
        }
        System.out.println(immagine);
        immagine.show();
    }
}
