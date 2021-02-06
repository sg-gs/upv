import java.net.*;
import java.util.*;

public class DatagramDayTimeServer
{
	public static void main(String args[])
	{
		try 
		{
			byte[] buffer = new byte[1000];
			DatagramPacket dp = new DatagramPacket(buffer, 1000);
			DatagramSocket ds = new DatagramSocket(7777);
	
			while(true) 
			{
				ds.receive(dp);

				Date now = new Date();
				String nowToString = now.toString() + "\r\n";
				dp.setData(nowToString.getBytes());
				dp.setLength(nowToString.length());
				ds.send(dp);			
			}
			
		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
	}	
}
