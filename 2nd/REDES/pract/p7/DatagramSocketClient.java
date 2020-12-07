

import java.io.*;
import java.net.*;

public class DatagramSocketClient
{
	public static void main(String args[])
	{
		try 
		{
			DatagramSocket ds = new DatagramSocket();
			int p = ds.getLocalPort();
			System.out.println("PORT: " + p);
		
		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
		
	}	

}
