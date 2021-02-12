import java.net.*;

public class Dnslookup
{
	public static void main(String args[])
	{
		try {
			String host = args[0];

			try {
				System.out.println("HOST: " + host);
				System.out.println("IP: " + InetAddress.getByName(host).toString().split("/")[1]);
			} catch (UnknownHostException uhe) {
				System.out.println("Unknown host " + host);
			} catch (Exception e) {
				System.out.println("Unexpected exception: " + e.getMessage());
			}

		} catch (ArrayIndexOutOfBoundsException aibe) {
			System.out.println(("Provide a host!"));
			System.out.println("Program usage: 'java Dnslookup ${host}'");
		}
	}	
}
