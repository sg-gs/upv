import java.net.*;
import java.io.*;
import java.util.Scanner;

class Ejercicio2
{
	public static void main (String args[]) 
	{
		try 
		{
			int puerto = 7777;
			ServerSocket ss = new ServerSocket(puerto);		
			while(true)
			{
				Socket s = ss.accept(); // socket que atiende al cliente
				
				// SERVER SOCKET
				System.out.println("getInetAddress ss: " + ss.getInetAddress());
				System.out.println("getLocalPort ss: " + ss.getLocalPort());
			
				// SOCKET
				System.out.println("getLocalAddress s: " + s.getLocalAddress());
				System.out.println("getLocalPort s: " + s.getLocalPort());
				System.out.println("getInetAddress s: " + s.getInetAddress());
				System.out.println("getPort s: " + s.getPort());

				System.out.println("Se ha conectado un cliente al servidor");
				Scanner entrada = new Scanner(s.getInputStream());
				PrintWriter salida = new PrintWriter(s.getOutputStream(), true);
				salida.println(entrada.nextLine());
				s.close();			
			}		
		} catch (IOException e)
		{
			System.out.println(e);		
		}	
	}
}
