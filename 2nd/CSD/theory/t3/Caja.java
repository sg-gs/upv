public class Caja {
    public int contenido = 0;
    private boolean llena = false;

    public synchronized int obtener() {
        while(!llena) {
            try { wait(); } catch (InterruptedException ie) {} 
        }
        int valor = contenido;
        contenido = 0;
        llena = false;
        notify();
        System.out.println("Consumidor #" + " obtiene: " + valor);
        return valor;
    }

    public synchronized void poner(int valor) {
        while(llena) {
            try { wait(); } catch (InterruptedException ie) {} 
        }
        llena = true;
        contenido = valor;
        notify();
        System.out.println("Productor #" + " pone: " + valor);
    }
}
