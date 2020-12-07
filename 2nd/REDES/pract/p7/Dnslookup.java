

import java.io.*;
import java.net.*;

public class Dnslookup
{
	public static void main(String args[])
	{
		try 
		{
			String host = args[0];
			System.out.println("HOST: " + host);
			System.out.println("IP: " + InetAddress.getByName(host).toString().split("/")[1]);
		
		} catch (UnknownHostException uhe) {
			System.out.println("Unknown host");
		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
		
	}	

}
