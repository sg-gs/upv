package p6;

import java.io.*;
import java.net.*;
import java.util.Scanner;


class ServerThread extends Thread 
{
	Socket s;

	public ServerThread(Socket s) 
	{
		this.s = s;
	}

	public void run ()
	{
		try {
			
			Scanner in = new Scanner(s.getInputStream());
			PrintWriter out = new PrintWriter(s.getOutputStream(), true);

			while (in.hasNext()) 
			{
				String nextLine = in.nextLine();
				
				if(nextLine.equals("FIN")) 
				{
					s.close();
					return;
				}			

				out.println(nextLine);			
			}
			
			
		} catch (Exception ie) {
			System.out.println("Interrupted Thread:" + ie.getMessage());
		}
	}
}
