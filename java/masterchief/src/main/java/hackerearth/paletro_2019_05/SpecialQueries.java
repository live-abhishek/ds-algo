package hackerearth.paletro_2019_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// TODO: partially accepted
public class SpecialQueries {
    static class Node {
        int num;
        BitSet parent = new BitSet();
        List<Node> nbrs = new ArrayList<>();
        boolean visited = false;

        Node(int num) {
            this.num = num;
            parent.set(num);
        }
    }

    public static void main(String[] args) throws Exception {
        FastReader fr = new FastReader();
        int N = fr.nextInt();
        List<Node> nodes = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            nodes.add(new Node(i));
        }
        for (int i = 0; i < N - 1; i++) {
            int u = fr.nextInt() - 1;
            int v = fr.nextInt() - 1;
            nodes.get(u).nbrs.add(nodes.get(v));
            nodes.get(v).nbrs.add(nodes.get(u));
        }
        nodes.get(0).visited = true;
        traverse(nodes, 0);
        int Q = fr.nextInt();
        for (int i = 0; i < Q; i++) {
            int u = fr.nextInt() - 1;
            int v = fr.nextInt() - 1;
            boolean vContainsU = nodes.get(v).parent.get(u);
            System.out.println(vContainsU ? "Yes" : "No");
        }
    }

    private static void traverse(List<Node> nodes, int source) {
        Node sourceNode = nodes.get(source);
        for (Node nbr : sourceNode.nbrs) {
            if(!nbr.visited) {
                nbr.visited = true;
                nbr.parent.or(sourceNode.parent);
                traverse(nodes, nbr.num);
            }
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
