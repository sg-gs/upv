import java.net.*;
import java.io.*;
import java.util.Scanner;

public class ClienteSMTP
{
	public static void main(String args[]) 
	{
		new ClienteSMTP();
    }

	public ClienteSMTP()
	{
		this.connect();
	}

    	public void connect() 
    	{
		try {
			// Ejercicio 8
			System.setProperty("line.separator", "\r\n");

			Socket s = new Socket("smtp.upv.es", 25);
			System.out.println("Connected!");

			// Recibir primer mensaje
			Scanner smtpUpv = new Scanner(s.getInputStream());
			System.out.println(">> zoltar.redes.upv.es: " + smtpUpv.nextLine());

			PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
			pw.println("HELO upv.es");

			// Recibir respuesta
			Scanner smtpUpvDos = new Scanner(s.getInputStream());
			System.out.println(">> zoltar.redes.upv.es: " + smtpUpvDos.nextLine());

			s.close();
		} 
		catch (UnknownHostException uhe)
		{
			System.out.println("Unknown Host");
		} 
		catch (ConnectException ce)
		{
			System.out.println("Cannot connect to the host");
		} 
		catch (Exception e)
		{
			System.out.println("Unknown exception" + e.getMessage());		
		}
	}
}
