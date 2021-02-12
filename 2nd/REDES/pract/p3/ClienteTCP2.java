import java.net.*;

public class ClienteTCP2 {
	public static void main(String args[]) {
		new ClienteTCP2();
	}

	public ClienteTCP2() {
		this.connect();
	}

	public void connect() {
		try {
			Socket s = new Socket("www.upv.es", 80);
			System.out.println("Conectado!");
			// Ejercicio 9
			System.out.println("Remote Port: " + s.getPort());
			System.out.println("Remote Host IP: " + s.getInetAddress());
			System.out.println("Local Socket Port: " + s.getLocalPort());
			System.out.println("Local Host IP: " + s.getLocalAddress());
			s.close();
		} catch (UnknownHostException uhe) {
			System.out.println("Nombre de servidor desconocido");
		} catch (ConnectException ioe) {
			System.out.println("No es posible realizar la conexión");
		} catch (Exception e) {
			System.out.println("Unknown exception" + e.getMessage());
		}
	}
}
