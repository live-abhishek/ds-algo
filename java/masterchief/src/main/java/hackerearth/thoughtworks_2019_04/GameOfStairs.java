package hackerearth.thoughtworks_2019_04;

import java.io.*;
import java.util.*;

public class GameOfStairs {

    public static void main(String[] args) throws Exception {
        FastReader fr = new FastReader();
        int t = fr.nextInt();
        for (int i = 0; i < t; i++) {
            int q = fr.nextInt();
            int[] blocks = new int[q];
            int[] steps = new int[q];
            for (int j = 0; j < q; j++) {
                blocks[j] = fr.nextInt();
            }
            for (int j = 0; j < q; j++) {
                steps[j] = fr.nextInt();
            }
            solveTC(blocks, steps);
        }
    }

    private static void solveTC(int[] blocks, int[] steps)  {
        List<Integer> ans = new ArrayList<>();
        PriorityQueue<Integer> leftPq = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> rightPq = new PriorityQueue<>();
        for (int i = 0; i < blocks.length; i++) {
            if(!leftPq.isEmpty() && blocks[i] > leftPq.peek()){
                rightPq.add(blocks[i]);
            } else {
                leftPq.add(blocks[i]);
            }
            int pos = getNthEle(rightPq, leftPq, steps[i]);
            ans.add(pos);
        }
        StringBuilder sb = new StringBuilder();
        for(int i : ans){
            sb.append(i).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        String output = sb.toString();
        System.out.println(output);
    }

    private static int getNthEle(PriorityQueue<Integer> rPq, PriorityQueue<Integer> lPq, int k) {
        int toRemove = k - lPq.size();
        if (toRemove > 0) { // remove from right & add to left
            for (int i = 0; i < toRemove - 1; i++) {
                Integer ele = rPq.poll();
                lPq.add(ele);
            }
            return rPq.peek();
        } else { // remove from left & add to right
            toRemove = -toRemove;
            for (int i = 0; i < toRemove; i++) {
                Integer ele = lPq.poll();
                rPq.add(ele);
            }
            return lPq.peek();
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() throws Exception {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
