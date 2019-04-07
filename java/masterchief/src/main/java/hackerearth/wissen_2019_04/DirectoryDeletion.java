package hackerearth.wissen_2019_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DirectoryDeletion {
    public static void main(String[] args) throws Exception {
        FastReader fr = new FastReader();
        int n = fr.nextInt();
        int[] parentArr = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            parentArr[i] = fr.nextInt();
        }
        int m = fr.nextInt();
        Set<Integer> toBeDeleted = new HashSet<>();
        for (int i = 0; i < m; i++) {
            toBeDeleted.add(fr.nextInt());
        }
        Map<Integer, List<Integer>> graph = getGraph(parentArr);
        int ans = getMinDirToDel(graph, toBeDeleted);
        System.out.println(ans);
    }

    private static int getMinDirToDel(Map<Integer, List<Integer>> graph, Set<Integer> ids) {
        return getMinDirToDel(graph, ids, -1);
    }

    private static int getMinDirToDel(Map<Integer, List<Integer>> g, Set<Integer> ids, Integer parent) {
        if (ids.contains(parent)) {
            return 1;
        } else {
            int sum = 0;
            List<Integer> children = g.getOrDefault(parent, new ArrayList<>());
            for (Integer child : children) {
                sum += getMinDirToDel(g, ids, child);
            }
            return sum;
        }
    }

    private static Map<Integer, List<Integer>> getGraph(int[] parArr){
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i < parArr.length; i++) {
            if (!map.containsKey(parArr[i])) {
                map.put(parArr[i], new ArrayList<>());
            }
            map.get(parArr[i]).add(i);
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
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

}
