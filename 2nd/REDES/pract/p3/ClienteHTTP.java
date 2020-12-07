import java.net.*;
import java.io.*;
import java.util.Scanner;

public class ClienteHTTP {
	public static void main(String args[]) {
		ClienteHTTP ct2 = new ClienteHTTP();
	}

	public ClienteHTTP() {
		this.connect();
	}

	public void connect() {
		try {
			Socket s = new Socket("www.upv.es", 80);
			System.out.println("Conectado!");

			// Enviar Request
			PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
			pw.printf("GET / HTTP/1.0\r\n\r\n");

			// Recibir respuesta
			Scanner upv = new Scanner(s.getInputStream());

			while (upv.hasNextLine()) {
				System.out.println(">> upv.es: " + upv.nextLine());
			}

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
