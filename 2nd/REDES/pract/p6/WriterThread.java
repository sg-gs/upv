package p6;

import java.io.*;
import java.net.*;
import java.util.Scanner;


class WriterThread extends Thread 
{
	Socket s;

	public WriterThread(Socket s) 
	{
		this.s = s;
	}

	public void run ()
	{
		try {
			
			Scanner in = new Scanner(System.in);
			PrintWriter out = new PrintWriter(s.getOutputStream(), true);

			while (in.hasNext()) 
			{
				String nextLine = in.nextLine();
				out.println(nextLine);			
			}
			
			
		} catch (Exception ie) {
			System.out.println("Interrupted Thread:" + ie.getMessage());
		}
	}
}
