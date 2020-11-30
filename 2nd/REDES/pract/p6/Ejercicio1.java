package p6;

class Ejercicio1 
{
	public static void main (String args[]) 
	{

		try {
			
			MyThread m1 = new MyThread("MyThread 1");
			m1.start();

			MyThread m2 = new MyThread("MyThread 2");
			m2.start();

			MyThread m3 = new MyThread("MyThread 3");		
			m3.start();
			
		} catch (Exception ie) {
			System.out.println("Interrupted Thread:" + ie.getMessage());
		}
	
	}
}
