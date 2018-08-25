package hackerrank;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Knapsack {
    private static Scanner sc;

    public static void main(String[] args) throws FileNotFoundException {
        sc = new Scanner(System.in);
        sc = new Scanner(new FileInputStream(Knapsack.class.getClassLoader()
                .getResource("Knapsack/input.txt").getFile()));
        int n = sc.nextInt(); sc.nextLine();
        IntStream.range(0, n).forEach( i -> solveTC());
        sc.close();
    }

    private static void solveTC(){
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] array = IntStream.range(0, n)
                .map(i -> sc.nextInt())
                .distinct().sorted().toArray();

        boolean[] dpTable = new boolean[k+1];
        dpTable[0] = true;
        for(int i = 1; i < k+1; i++){
            for(int j : array){
                if(i < j ) break;
                if(dpTable[i-j]){
                    dpTable[i] = true;
                    break;
                }
            }
        }
        int max = 0;
        for(int i = k; i >= 0; i--){
            if(dpTable[i]){
                max = i;
                break;
            }
        }
        System.out.println(max);
    }
}
