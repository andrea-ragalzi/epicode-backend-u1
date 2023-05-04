public class Es1 {
    public static void main(String[] args) {
        String test1 = "Hello World!";
        System.out.println(test1 + ": " + stringaPariDispari(test1));
        String test2 = "H";
        System.out.println(test2 + ": " + stringaPariDispari(test2));
        String test3 = "Ciao";
        System.out.println(test3 + ": " + stringaPariDispari(test3));
        int test4 = 1994;
        System.out.println(test4 + ": " + annoBisestile(test4));
        int test5 = 2000;
        System.out.println(test5 + ": " + annoBisestile(test5));
        int test6= 2024;
        System.out.println(test6 + ": " + annoBisestile(test6));
    }

    public static boolean stringaPariDispari(String target) {
        return target.length() % 2 == 0;
    }

    public static boolean annoBisestile(int anno) {
        if (anno % 4 != 0) {
            return false;
        } else if (anno % 400 == 0) {
            return true;
        } else if (anno % 100 == 0) {
            return false;
        } else {
            return true;
        }
    }
}