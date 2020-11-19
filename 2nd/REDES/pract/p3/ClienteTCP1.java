import java.net.*;
import java.io.*;

public class ClienteTCP1
{
    public static void main(String args[]) throws UnknownHostException, IOException 
    {
        int PORT = 80;
        String HOST = "www.upv.es";
        Socket s = new Socket(HOST, PORT);
	    System.out.println("Connected!");
        s.close();
    }
}
