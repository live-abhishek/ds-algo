package multithreading;

import java.util.HashSet;

public class RateLimitingUsingTokenBucketFilter {
    private final int maxTokens;
    int possibleTokens = 0;
    long lastReqTime = System.currentTimeMillis();

    public RateLimitingUsingTokenBucketFilter(int maxTokens) {
        this.maxTokens = maxTokens;
    }

    public synchronized void getToken() throws InterruptedException {
        possibleTokens += (System.currentTimeMillis() - lastReqTime) / 1000;
        if (possibleTokens > maxTokens) {
            possibleTokens = maxTokens;
        }
        if (possibleTokens == 0) {
            Thread.sleep(1000*2);
        } else {
            possibleTokens--;
        }
        lastReqTime = System.currentTimeMillis();
        System.out.println(String.format("Grant token to %s at time %d" ,  Thread.currentThread().getName(), (System.currentTimeMillis() / 1000)));
    }

    public static void main(String[] args) throws InterruptedException {
        HashSet<Thread> threads = new HashSet<>();
        RateLimitingUsingTokenBucketFilter tokenBucketFilter = new RateLimitingUsingTokenBucketFilter(5);
        // Sleep for 10 seconds
        Thread.sleep(10000);
        for (int i = 0; i < 15; i++) {
            Thread t = new Thread(() -> {
                try {
                    tokenBucketFilter.getToken();
                } catch (InterruptedException e) {

                }
            });
            t.setName("Thread_" + (i + 1));
            threads.add(t);
        }
        threads.forEach(Thread::start);
        for (Thread thread : threads) {
            thread.join();
        }
    }
}
