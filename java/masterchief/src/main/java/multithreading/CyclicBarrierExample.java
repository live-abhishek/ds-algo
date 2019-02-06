package multithreading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        CyclicBarrier barrier = new CyclicBarrier(5, () ->
                System.out.println("All tasks finished."));
        for (int i = 0; i < 5; i++) {
            int j = i;
            executorService.execute(() -> {
                System.out.println(String.format("Task %d started", j));
                try {
                    Thread.sleep(1000);
                    System.out.println(String.format("Task %d finished. " +
                            "Awaiting other tasks to complete", j));
                    barrier.await();
                    Thread.sleep(1000);
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println(String.format("Task %d cleanup.", j));
            });
        }
        executorService.shutdown();
    }
}
