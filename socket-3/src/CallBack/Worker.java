package CallBack;

// Worker.java
public class Worker {
    public void doWork(Callback callback) {
        System.out.println("仕事中...");

        // Simulating some work with a thread sleep
        try {
            Thread.sleep(4000); // 2 seconds delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Work is done, now call the callback method
        callback.onComplete("終わった！");
    }
}
