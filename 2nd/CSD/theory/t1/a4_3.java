public class a4_3 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread tt = new Thread() {
                public void run () {
                    for (int j = 0; j < 3; j++) {
                        printMsg();
                    }
                }

                public void printMsg () {
                    System.out.println("name=" + Thread.currentThread().getName());
                }
            };

            tt.setName("MyThread" + i);

            if (i < 5) tt.start();
        }
    }    
}
