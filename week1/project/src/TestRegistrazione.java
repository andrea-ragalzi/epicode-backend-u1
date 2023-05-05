public class TestRegistrazione {
    public static void main(String[] args) {
        Registrazione registrazione = new Registrazione("Fiume", 3, 5);
        System.out.println(registrazione);
        registrazione.play();
        for (int i = 0; i < 10; i++) {
            registrazione.alzaVolume();
        }
        System.out.println(registrazione);
        registrazione.play();
        for (int i = 0; i < 15; i++) {
            registrazione.abbassaVolume();
        }
        System.out.println(registrazione);
        registrazione.play();
    }
}





