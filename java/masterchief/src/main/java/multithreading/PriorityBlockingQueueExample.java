package multithreading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class PriorityBlockingQueueExample {
    public static void main(String[] args) {
        BlockingQueue<Character> queue = new PriorityBlockingQueue<>();

        Thread producer = new Thread(() -> {
            try {
                queue.put('d');
                queue.put('e');
                Thread.sleep(1000);
                queue.put('a');
                queue.put('c');
                Thread.sleep(4000);
                queue.put('b');
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                System.out.println(queue.take());
                Thread.sleep(2000);
                System.out.println(queue.take());
                System.out.println(queue.take());
                Thread.sleep(1000);
                System.out.println(queue.take());
                System.out.println(queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        producer.start();
        consumer.start();
    }
}
