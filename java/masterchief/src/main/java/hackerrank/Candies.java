package hackerrank;

import java.io.*;

/**
 * https://www.hackerrank.com/challenges/candies/problem
 */
public class Candies {

    static BufferedReader br;
    static PrintWriter pr;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        pr = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
        int n = Integer.valueOf(br.readLine());
        int[] arr = readNLinesIntoArray(n);
        solveTc(arr);

        br.close();
        pr.close();
    }

    private static int[] readNLinesIntoArray(int n) throws IOException {
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.valueOf(br.readLine());
        }
        return arr;
    }

    private static void solveTc(int[] arr){
        int[] runLR = new int[arr.length];
        runLR[0] = 1;
        for(int i = 1; i < arr.length; i++){
            if(arr[i] > arr[i-1]){
                runLR[i] = runLR[i-1] + 1;
            } else {
                runLR[i] = 1;
            }
        }

        int[] runRL = new int[arr.length];
        runRL[arr.length-1] = 1;
        for(int i = arr.length-2; i >= 0; i--){
            if(arr[i] > arr[i+1]){
                runRL[i] = runRL[i+1] + 1;
            } else {
                runRL[i] = 1;
            }
        }

        long sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += Integer.max(runLR[i], runRL[i]);
        }
        pr.println(sum);
    }
}
