package hackerearth.thoughtworks_2019_04;

import java.io.*;
import java.util.*;

public class StringSimplification {

    public static void main(String[] args) throws Exception {
        FastReader fr = new FastReader();
        int k = fr.nextInt();
        String str = fr.next();
        Map<Character, Integer> fullMap = getFullMap(str);
        Map<Character, Integer> currMap = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < str.length() - 1; i++) {
            char c = str.charAt(i);
            currMap.put(c, currMap.getOrDefault(c, 0)+1);
            boolean checkPartition = checkPartition(fullMap, currMap, k);
            if (checkPartition) {
                ans++;
            }
        }
        System.out.println(ans);
    }

    private static boolean checkPartition(Map<Character, Integer> fullMap, Map<Character, Integer> currMap, int k) {
        int matched = 0;
        for (Character c : currMap.keySet()) {
            int currMapCharCount = currMap.get(c);
            int fullMapCharCount = fullMap.get(c);
            if (currMapCharCount * 2 == fullMapCharCount) {
                matched++;
                if (matched == k) {
                    return true;
                }
            }
        }
        return matched == k;
    }

    private static Map<Character, Integer> getFullMap(String string) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
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
