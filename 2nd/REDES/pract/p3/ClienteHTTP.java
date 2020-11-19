import java.net.*;
import java.io.*;
import java.util.Scanner;

public class ClienteHTTP
{
	public static void main(String args[]) 
	{
		new ClienteHTTP();
    }

	public ClienteHTTP()
	{
		this.connect();
	}

	public void connect() 
	{
		try {
			Socket s = new Socket("www.upv.es", 80);
			System.out.println("Connected!");

			// Enviar Request
			PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
			pw.printf("GET / HTTP/1.0\r\n\r\n");

			// Recibir respuesta
			Scanner upv = new Scanner(s.getInputStream());

			while(upv.hasNextLine())
			{
				System.out.println(">> upv.es: " + upv.nextLine());
			}

			s.close();
		} 
		catch (UnknownHostException uhe)
		{
			System.out.println("Unknown Host");
		} 
		catch (ConnectException ce)
		{
			System.out.println("Cannot connect to the server");
		} 
		catch (Exception e)
		{
			System.out.println("Unknown exception" + e.getMessage());		
		}
	}
}
