class MyThread extends Thread {
    private String message;
    
    public MyThread(String message) {
        this.message = message;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(message);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
        MyThread t1 = new MyThread("Thread A is running...");
        MyThread t2 = new MyThread("Thread B is running...");
        
        t1.start();
        t2.start();
    }
}