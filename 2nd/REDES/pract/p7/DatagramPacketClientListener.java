import java.net.*;

public class DatagramPacketClientListener
{
	public static void main(String args[])
	{
		try 
		{
			String msg = new String("eee\n");
			byte [] buf = new byte[256];
			byte [] msgBytes = msg.getBytes();

			for(int i = 0; i < msg.length(); i++) {
				buf[i] = msgBytes[i]; // refill buffer but keeping 256 as the size
			}

			DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("localhost"), 7777);
			DatagramSocket ds = new DatagramSocket();

			ds.send(dp);
			ds.receive(dp); // blocking

			String response = new String(dp.getData(), 0, dp.getLength()); // get length will return 256. So we can receive a message up to 256 chars
			System.out.println("RESPONSE: " + response);

			ds.close(); // don't waste resources!
		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
		
	}	

}
