package p6;

import java.lang.*;

class MyThread extends Thread 
{
	String msg;

	public MyThread(String msg) 
	{
		this.msg = msg;	
	}

	public void run ()
	{
		try {
			
			for(int i = 0; i < 10; i++)
			{
				System.out.println(msg);
				sleep(1000);
			}
			
		} catch (Exception ie) {
			System.out.println("Interrupted Thread:" + ie.getMessage());
		}
	}
}
