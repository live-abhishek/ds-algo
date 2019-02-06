package multithreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchExample {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CountDownLatch latch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            // because variable used inside lambda should be effectively final,
            // so copying value of i inside another effectively final variable j
            int j = i;
            // add new runnable worker
            executorService.execute(() -> {
                System.out.println(String.format("Task %d working", j));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(String.format("Task %d completed", j));
                latch.countDown();
            });
        }
        // calling thread gets blocked till countdown reaches zero
        // once countdown latch reaches zero it is no more usable
        latch.await();
        System.out.println("All tasks completed");
        executorService.shutdown();
    }

}

