public class CuentaBancaria {
    private long identificador;
    private long saldo;

    public CuentaBancaria(long id) {
        identificador = id;
    }

    public void reintegro(long cantidad) {
        saldo -= cantidad;
    }

    public void abono(long cantidad) {
        saldo += cantidad;
    }

    public long saldo() {
        return saldo;
    }

    public long idCuenta() {
        return identificador;
    }

    public void aplicarInteresesMensuales() {
        if (saldo > 50000)
            saldo *= 1.002;
        else if (saldo > 10000)
            saldo *= 1.001;
        saldo -= 2; // También hay comisiones :-(
    }
}