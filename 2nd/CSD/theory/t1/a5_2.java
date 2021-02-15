class Calculator extends Thread {
    private String result = "Not calculated";

    public void run() {
        result = calculate();
    }

    private String calculate() {
        // Performs a long-time calculation
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {};

        System.out.println("Agent thread finishes its calculation");
        return "Calculation done";
    }

    public String getResults() {
        return result;
    }
}

public class a5_2 {
    public static void main(String[] args) {
        Calculator agent = new Calculator();
        agent.start();
        // It does something durixng the calculation process
        System.out.println("Main in execution");

        while(agent.isAlive()) {}

        // Employs the result
        System.out.println(agent.getResults());
    }
}