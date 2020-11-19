import java.net.*;
import java.io.*;
import java.util.Scanner;

public class ClienteEco
{
	public static void main(String args[]) 
	{
		new ClienteEco();
    }

	public ClienteEco()
	{
		this.connect();
	}

	public void connect() 
	{
		try {
			Socket s = new Socket("zoltar.redes.upv.es", 7);
			System.out.println("Connected!");

			// PrintWriter pw = new PrintWriter(s.getOutputStream(), false);
			// pw.println("Hello World!");
			
			// First fix, explicitly flushing
			// PrintWriter pw = new PrintWriter(s.getOutputStream(), false);
			// pw.println("Hello World!");
			// pw.flush();

			// Second fix, using autoFlush
			PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
			pw.println("Hello World!");

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
		catch (ConnectException ioe)
		{
			System.out.println("Cannot connect to the host");
		} 
		catch (Exception e)
		{
			System.out.println("Unknown exception" + e.getMessage());		
		}
	}
}
