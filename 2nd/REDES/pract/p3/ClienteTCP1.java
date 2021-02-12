import java.net.*;
import java.io.*;

public class ClienteTCP1 {
    public static void main(String args[]) throws UnknownHostException, IOException {
        int puerto = 80;
        String servidor = "www.upv.es";
        Socket s = new Socket(servidor, puerto);
        System.out.println("Conectado!");
        s.close();
    }
}
