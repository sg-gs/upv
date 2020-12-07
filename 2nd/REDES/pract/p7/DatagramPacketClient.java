

import java.io.*;
import java.net.*;

public class DatagramPacketClient
{
	public static void main(String args[])
	{
		try 
		{
			String myName = new String("Sergio GV\n");
			DatagramPacket dp = new DatagramPacket(myName.getBytes(), myName.getBytes().length, InetAddress.getByName("localhost"), 7777);
			DatagramSocket ds = new DatagramSocket();
			ds.send(dp);
		
		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
		
	}	

}
