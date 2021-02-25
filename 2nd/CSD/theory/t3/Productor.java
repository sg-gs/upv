public class Productor extends Thread {
    private Caja caja;
    private int prodnumber;
    public Productor (Caja c, int number) {
        caja = c; 
        prodnumber = number;
    }

    public void run () {
        for (int i = 1; i < 11; i++) {
            caja.poner(i);
            // System.out.println("Productor #" + prodnumber + " pone: " + i);

            try {
                sleep((int) (Math.random() * 3));
            } catch (InterruptedException ie) {
                System.out.println("Productor interrupted exception!");
            }
        }
    }
}
