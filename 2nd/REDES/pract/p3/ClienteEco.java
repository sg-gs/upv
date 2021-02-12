import java.net.*;
import java.io.*;
import java.util.Scanner;

public class ClienteEco {
	public static void main(String args[]) {
		new ClienteEco();
	}

	public ClienteEco() {
		this.connect();
	}

	public void connect() {
		try {
			Socket s = new Socket("zoltar.redes.upv.es", 7);
			System.out.println("Conectado!");

			// PrintWriter pw = new PrintWriter(s.getOutputStream(), false);
			// pw.println("¡¡Hola Mundo!!");
			// Primera corrección
			// PrintWriter pw = new PrintWriter(s.getOutputStream(), false);
			// pw.println("¡¡Hola Mundo!!");
			// pw.flush();

			// Segunda corrección, con autoFlush
			PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
			pw.println("¡¡Hola Mundo!!");

			Scanner zoltar = new Scanner(s.getInputStream());
			while (zoltar.hasNext()) {
				System.out.println(">> zoltar.redes.upv.es: " + zoltar.nextLine());
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
