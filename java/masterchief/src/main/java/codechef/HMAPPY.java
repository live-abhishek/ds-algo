package codechef;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class HMAPPY {
    public static class Day {
        public long b, c;
        public Day(long b, long c){ this.b = b; this.c = c; }
        public long getTotalCandy(){ return b * c; }
    }
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {
        sc = new Scanner(new FileInputStream(HMAPPY.class.getClassLoader()
                .getResource("codechef/HMAPPY.txt").getFile()));
        int n = sc.nextInt();
        long m = sc.nextLong();
        long[] balloons = LongStream.range(0, n).map(i -> sc.nextLong()).toArray();
        long[] candies = LongStream.range(0, n).map(i -> sc.nextLong()).toArray();
        PriorityQueue<Day> pq = new PriorityQueue<Day>(Comparator.comparing(Day::getTotalCandy).reversed());
        // fill priority queue
        IntStream.range(0, n).forEach(i -> pq.add(new Day(balloons[i], candies[i])));

        while(pq.peek().getTotalCandy() > 0 && m > 0){
            Day greatestCandyDay = pq.poll();
            long candyDiff = greatestCandyDay.getTotalCandy() - pq.peek().getTotalCandy();
            long possibleBalloonToGive = (long)Math.ceil(candyDiff / (double)greatestCandyDay.c);
            if(possibleBalloonToGive > m){
                possibleBalloonToGive = m;
            } else if(possibleBalloonToGive == 0){
                possibleBalloonToGive = 1;
            }
            greatestCandyDay.b -= possibleBalloonToGive;
            pq.add(greatestCandyDay);
            m -= possibleBalloonToGive;
        }
        Day greatestCandyDay = pq.peek();
        System.out.println(greatestCandyDay.b * greatestCandyDay.c);
    }
}
