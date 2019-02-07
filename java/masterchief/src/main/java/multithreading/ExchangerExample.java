package multithreading;

import java.util.concurrent.Exchanger;

public class ExchangerExample {
    static class Incrementer implements Runnable{

        private int counter;
        private Exchanger<Integer> exchanger;

        public Incrementer(Exchanger<Integer> exchanger) {
            this.exchanger = exchanger;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    counter = counter + 1;
                    System.out.println("Incrementing counter " + counter);
                    counter = exchanger.exchange(counter);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Decrementer implements Runnable{
        private int counter;
        private Exchanger<Integer> exchanger;

        public Decrementer(Exchanger<Integer> exchanger) {
            this.exchanger = exchanger;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    counter = counter - 1;
                    System.out.println("Decrementing counter " + counter);
                    counter = exchanger.exchange(counter);
//                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Exchanger<Integer> exchanger = new Exchanger<>();
        new Thread(new Incrementer(exchanger)).start();
        new Thread(new Decrementer(exchanger)).start();
    }
}
