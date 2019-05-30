package multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerBlockingQueueExample {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
        Runnable producer = () -> {
            int counter = 0;
            while (true) {
                try {
                    queue.put(counter++);
                    System.out.println(String.format("Producing item %d", counter));
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable consumer = () -> {
            while(true) {
                try {
                    Integer num = queue.take();
                    System.out.println(String.format("Consumer got %d", num));
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        new Thread(producer).start();
        new Thread(consumer).start();

    }
}
