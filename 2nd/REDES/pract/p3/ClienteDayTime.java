import java.net.*;
import java.io.*;
import java.util.Scanner;

public class ClienteDayTime
{
	public static void main(String args[]) 
	{
		ClienteDayTime ct2 = new ClienteDayTime();
    	}

	public ClienteDayTime()
	{
		this.connect();
	}

    	public void connect() 
    	{
		try {
			Socket s = new Socket("zoltar.redes.upv.es", 13);
			System.out.println("Conectado!");
			// Leer primera linea y pintarla
			Scanner zoltar = new Scanner(s.getInputStream());
			while(zoltar.hasNext()) 
			{
				System.out.println(">> zoltar.redes.upv.es: " + zoltar.nextLine());
			}
			s.close();
		} 
		catch (UnknownHostException uhe)
		{
			System.out.println("Nombre de servidor desconocido");
		} 
		catch (ConnectException ioe)
		{
			System.out.println("No es posible realizar la conexión");
		} 
		catch (Exception e)
		{
			System.out.println("Unknown exception" + e.getMessage());		
		}
	}
}
