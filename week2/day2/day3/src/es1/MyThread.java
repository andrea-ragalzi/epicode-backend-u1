package es1;

public class MyThread extends Thread {
    private char id_thread;

    public MyThread(char id_thread) {
        this.id_thread = id_thread;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(id_thread + " - " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
