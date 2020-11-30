package p6;

import java.io.*;
import java.net.*;

public class Client
{
	public static void main(String argv[]) throws UnknownHostException, IOException 
	{
		int port = 7777;
		Socket server = new Socket("localhost", port);	

		ReaderThread rt = new ReaderThread(server);
		WriterThread wt = new WriterThread(server);
		rt.start(); 
		wt.start();			
	}	

}
