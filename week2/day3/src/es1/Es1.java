package es1;
public class Es1 {
    public static void main(String[] args) throws Exception {
        System.out.println("Thread Genitore");
        MyThread thread1 = new MyThread('*');
        MyThread thread12 = new MyThread('#');
        thread1.start();
        thread12.start();
    }
}
