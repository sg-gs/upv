package p6;

import java.io.*;
import java.net.*;
import java.util.Scanner;


class ReaderThread extends Thread 
{
	Socket s;

	public ReaderThread(Socket s) 
	{
		this.s = s;
	}

	public void run ()
	{
		try {
			
			Scanner in = new Scanner(s.getInputStream());

			while (in.hasNext()) 
			{			
				System.out.println(in.nextLine());			
			}
			
			
		} catch (Exception ie) {
			System.out.println("Interrupted Thread:" + ie.getMessage());
		}
	}
}
