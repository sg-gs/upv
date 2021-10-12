public class a8 {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(() -> {
                System.out.println("executed by" + Thread.currentThread().getName());
            });

            t.setName("MyThread" + i);
            t.start();
        }
    }
}
