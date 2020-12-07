

import java.io.*;
import java.net.*;

public class DatagramPacketClientListener
{
	public static void main(String args[])
	{
		try 
		{
			String msg = new String("eee\n");
			DatagramPacket dp = new DatagramPacket(msg.getBytes(), msg.getBytes().length, InetAddress.getByName("localhost"), 7777);
			DatagramSocket ds = new DatagramSocket();
			ds.send(dp);
			ds.receive(dp);
			String response = new String(dp.getData(), 0, dp.getLength());
			System.out.println("RESPONSE: " + response);
		
		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
		
	}	

}
