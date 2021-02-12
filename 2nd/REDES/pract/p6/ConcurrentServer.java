package p6;

import java.io.*;
import java.net.*;

public class ConcurrentServer
{
	public static void main(String argv[]) throws UnknownHostException, IOException 
	{
		int port = 7777;
		ServerSocket server = new ServerSocket(port);	

		while(true)
		{
			Socket client = server.accept();
			ServerThread st = new ServerThread(client);
			st.start();			
		}
	}	

}
