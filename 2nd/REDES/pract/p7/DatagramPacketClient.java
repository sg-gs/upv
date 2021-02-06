import java.net.*;

public class DatagramPacketClient
{
	public static void main(String args[])
	{
		System.out.println("Usage: open two terminal tabs");
		System.out.println("1) nc -k -u -l 7777 ");
		System.out.println("2) javac DatagramPacketClient.java && java DatagramPacketClient ");

		try {
			String myName = new String("Sergio GV\n");

			// UDP datagram packet structure
			System.out.println("=============================================");
			System.out.println("| Message (Byte array) |  Msg length  |   IP dir   |   Port  |");
			System.out.println("=============================================");

			DatagramPacket dp = new DatagramPacket(myName.getBytes(), myName.getBytes().length, InetAddress.getByName("localhost"), 7777);
			DatagramSocket ds = new DatagramSocket();
			ds.send(dp);
			ds.close();
		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
		
	}	

}
