package val.examples.threads;

public class Hilos extends Thread {
    public Hilos(String str) {
        super(str);
    }
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Km " + i + " : " + getName());
            try {
                sleep((long)(Math.random() * 2500));
            } catch (InterruptedException e) {}
        }
        System.out.println("Llego a la meta! " + getName());
    }
}