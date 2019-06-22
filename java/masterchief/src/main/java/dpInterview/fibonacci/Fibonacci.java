package dpInterview.fibonacci;

public class Fibonacci {

    public int CalculateFibonacci(int n) {
        if (n < 2) {
            return n;
        }
        int n0 = 0, n1 = 1, temp;
        for (int i = 2; i <= n; i++) {
            temp = n0 + n1;
            n0 = n1;
            n1= temp;
        }
        return n1;
    }

        public static void main(String[] args) {
        Fibonacci fib = new Fibonacci();
        System.out.println("5th Fibonacci is ---> " + fib.CalculateFibonacci(5));
        System.out.println("6th Fibonacci is ---> " + fib.CalculateFibonacci(6));
        System.out.println("7th Fibonacci is ---> " + fib.CalculateFibonacci(7));
    }
}
