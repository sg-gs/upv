public class CondicionDeCarrera {
    public static void main(String [] args) {
        Caja c = new Caja();
        Consumidor c1 = new Consumidor(c, 1);
        Productor p1 = new Productor(c, 1);

        c1.start();
        p1.start();

        try {
            c1.join();
            p1.join();

            System.out.println("Todos los hilos han finalizado, contenido final de la caja: " + c.contenido);
        } catch (InterruptedException ie) {}
        
    }
}
