import java.net.*;
import java.io.*;
import java.util.Scanner;

class Ejercicio3
{
	public static void main (String args[]) 
	{
		try 
		{
			int puerto = 8000;
			ServerSocket ss = new ServerSocket(puerto);		
			while(true)
			{
				Socket s = ss.accept(); // socket que atiende al cliente
				PrintWriter salida = new PrintWriter(s.getOutputStream(), true);
				salida.printf("HTTP/1.0 200 OK \r\n");
				salida.printf("Content-Type: text/plain \r\n");
				salida.printf("\r\n");
				
				Scanner entrada = new Scanner(s.getInputStream());

				String cadena = entrada.nextLine();

				while(!cadena.equals(""))
				{
					salida.printf(cadena + "\r\n");
					cadena = entrada.nextLine();
				}				
					
				s.close();			
			}		
		} catch (IOException e)
		{
			System.out.println(e);		
		}	
	}
}
