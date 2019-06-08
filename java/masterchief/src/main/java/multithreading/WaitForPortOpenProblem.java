package multithreading;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WaitForPortOpenProblem {
    static class Worker implements Runnable {

        private final CountDownLatch startLatch;
        private final CountDownLatch endLatch;
        private final int num;

        Worker(int num, CountDownLatch startLatch, CountDownLatch endLatch) {
            this.num = num;
            this.startLatch = startLatch;
            this.endLatch = endLatch;
        }

        @Override
        public void run() {
            try {
                startLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            performTask();
            endLatch.countDown();
        }

        private void performTask(){
            System.out.println(String.format("Thread %d starting task", this.num));
            // sleep for a random amount of time between 1000ms to 5000ms
            int randomSleepTime = (1 + new Random().nextInt(5)) * 1000;
            try {
                Thread.sleep(randomSleepTime);
            } catch (InterruptedException e) {
                // skip
            }
            System.out.println(String.format("Thread %d completed task", this.num));
        }
    }

    static class PortHandler implements Runnable {

        private final CountDownLatch startLatch;
        private final CountDownLatch endLatch;

        PortHandler(CountDownLatch startLatch, CountDownLatch endLatch) {
            this.startLatch = startLatch;
            this.endLatch = endLatch;
        }

        @Override
        public void run() {
            openPort();
            startLatch.countDown();
            try {
                endLatch.await();
            } catch (InterruptedException e) {
                // skip
            }
            closePort();
        }

        private void openPort(){
            System.out.println("Port opened");
        }

        private void closePort(){
            System.out.println("Port closed");
        }
    }

    public static void main(String[] args) {
        CountDownLatch startLatch = new CountDownLatch(1);
        CountDownLatch endLatch = new CountDownLatch(5);
        Thread portHandlerThread = new Thread(new PortHandler(startLatch, endLatch));
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 1; i <= 5; i++) {
            executorService.submit(new Worker(i, startLatch, endLatch));
        }
        portHandlerThread.start();
        executorService.shutdown();
    }
}
