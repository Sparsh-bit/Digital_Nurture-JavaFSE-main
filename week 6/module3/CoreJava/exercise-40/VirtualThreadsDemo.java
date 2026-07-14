public class VirtualThreadsDemo {
    public static void main(String[] args) {
        System.out.println("Starting 100,000 virtual threads...");
        
        long start = System.currentTimeMillis();
        
        for (int i = 0; i < 100_000; i++) {
            Thread.startVirtualThread(() -> {
                try {
                    Thread.sleep(1000); // simulate I/O wait
                } catch (InterruptedException e) {}
            });
        }
        
        long end = System.currentTimeMillis();
        System.out.println("Launched them all in " + (end - start) + " ms!");
        
        // Note: With traditional OS threads, launching 100,000 would immediately crash 
        // the JVM with an OutOfMemoryError. Virtual threads handle it effortlessly.
    }
}