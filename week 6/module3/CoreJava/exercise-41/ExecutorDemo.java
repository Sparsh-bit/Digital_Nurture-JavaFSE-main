import java.util.concurrent.*;

public class ExecutorDemo {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        
        Callable<Integer> task = () -> {
            System.out.println("Calculating in thread: " + Thread.currentThread().getName());
            Thread.sleep(1000); // Simulate heavy work
            return 42;
        };
        
        try {
            Future<Integer> futureResult = executor.submit(task);
            System.out.println("Waiting for result...");
            
            // get() blocks until the thread is done
            Integer result = futureResult.get(); 
            System.out.println("Result returned: " + result);
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}