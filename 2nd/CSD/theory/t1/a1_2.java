// public class T implements Runnable { 
public class a1_2 implements Runnable { // looking for this?
    // a1_2 is a very BAD naming, but java linter cries if className != fileName
    protected int n;
    public a1_2(int n) {
        this.n = n;
    }

    public void delay(int ms) {
        // suspends execution for ms milliseconds
        try { 
            Thread.sleep(ms); // pay attention to this line
        } catch (InterruptedException ie){
            ie.printStackTrace();
        }
    }

    public void run() {
        for (int i=0; i<10; i++) {
            System.out.println("Thread "+n +" iteration "+i);
            delay((n+1)*1000);
        }
        System.out.println("End of thread "+n);
    }

    public static void main(String[] argv) {
        System.out.println("--- Begin of execution ---- ");

        for (int i=0; i<6; i++) {
            new Thread(new a1_2(i)).start(); // looking for this too?
        }

        System.out.println("--- End of execution ---- ");
    }
}
