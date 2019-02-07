package multithreading;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ConcurrentMapExample {
    public static void main(String[] args) {
        ConcurrentMap<Character, Integer> map = new ConcurrentHashMap<>();
        Thread producer = new Thread(() -> {
            try {
                map.put('b', 2);
                Thread.sleep(1000);
                map.put('a', 1);
                map.put('d', 4);
                Thread.sleep(2000);
                map.put('c', 3);
                map.put('e', 5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread consumer = new Thread(() -> {
            try {
                System.out.println(map.get('a'));
                Thread.sleep(2000);
                System.out.println(map.get('b'));
                System.out.println(map.get('c'));
                Thread.sleep(2000);
                System.out.println(map.get('d'));
                System.out.println(map.get('e'));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        producer.start();
        consumer.start();
    }
}
