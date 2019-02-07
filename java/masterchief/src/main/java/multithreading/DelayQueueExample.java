package multithreading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayQueueExample {
    static class DelayedWorker implements Delayed{

        private long duration;
        private String message;

        public DelayedWorker(long duration, String message) {
            this.duration = System.currentTimeMillis() + duration;
            this.message = message;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(this.duration - System.currentTimeMillis(),
                    TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed other) {
            if(this.duration < ((DelayedWorker)other).getDuration()){
                return -1;
            } else if( this.duration == ((DelayedWorker) other).getDuration()){
                return 0;
            } else {
                return 1;
            }
        }

        public long getDuration() {
            return duration;
        }

        public void setDuration(long duration) {
            this.duration = duration;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        @Override
        public String toString() {
            return this.message;
        }
    }

    public static void main(String[] args) {
        BlockingQueue<DelayedWorker> queue = new DelayQueue<>();
        try {
            queue.put(new DelayedWorker(1000, "This is the first message..."));
            queue.put(new DelayedWorker(10000, "This is the second message..."));
            queue.put(new DelayedWorker(4000, "This is the third message..."));

            while (!queue.isEmpty()) {
                System.out.println(queue.take());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
