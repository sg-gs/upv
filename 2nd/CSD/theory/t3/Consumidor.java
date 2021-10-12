public class Consumidor extends Thread {
    private Caja caja;
    private int cnumber;

    public Consumidor(Caja c, int number) {
        caja = c;
        cnumber = number;
    }

    public void run () {
        int value = 0;

        for(int i = 1; i <11; i++) {
            value = caja.obtener();
            // System.out.println("Consumidor #" + cnumber + " obtiene: " + value);
            try {
                sleep((int) (Math.random() * 3));
            } catch (InterruptedException e) {
                System.out.println("Interrupted exception!");
            }
        }
    }
}