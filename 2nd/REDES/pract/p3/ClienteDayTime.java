import java.net.*;
import java.util.Scanner;

public class ClienteDayTime
{
	public static void main(String args[]) 
	{
		new ClienteDayTime();
    }

	public ClienteDayTime()
	{
		this.connect();
	}

	public void connect() 
	{
		try {
			String HOST = "zoltar.redes.upv.es";
			int PORT = 13;
			Socket s = new Socket(HOST, PORT);
			System.out.println("Connected!");
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
