package hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Day3EngineeringEntranceExam {
    static class Nbr {
        Node node;
        int weight;
        public Nbr(Node node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
    static class Node {
        List<Nbr> nbrs = new ArrayList<>();
        int num;
        int srcDist;

        public Node(int num) {
            this.num = num;
            this.srcDist = Integer.MAX_VALUE;
        }
    }

    static class HeapNode implements Comparable<HeapNode> {
        int dist;
        Node node;

        HeapNode(Node node, int dist) {
            this.node = node;
            this.dist = dist;
        }
        @Override
        public int compareTo(HeapNode o) {
            return this.dist == o.dist
                    ? this.node.num - o.node.num
                    : this.dist - o.dist;
        }
    }

    static class Graph {
        List<Node> nodes;

        Graph(int size) {
            nodes = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                nodes.add(new Node(i));
            }
        }

        void addEdge(int u, int v, int w) {
            Node node1 = nodes.get(u);
            Node node2 = nodes.get(v);
            node1.nbrs.add(new Nbr(node2, w));
            node2.nbrs.add(new Nbr(node1, w));
        }

        void ssspDijkstra(int[] sources) {
            PriorityQueue<HeapNode> pq = new PriorityQueue<>();
            for (int src : sources) {
                if (src < 0) {
                    continue;
                }
                nodes.get(src).srcDist = 0;
                pq.add(new HeapNode(nodes.get(src), 0));
            }
            while (!pq.isEmpty()) {
                HeapNode curr = pq.remove();
                if (curr.dist > curr.node.srcDist) {
                    continue;
                }
                for (Nbr nbr : curr.node.nbrs) {
                    if (curr.node.srcDist + nbr.weight < nbr.node.srcDist) {
                        nbr.node.srcDist = curr.node.srcDist + nbr.weight;
                        pq.add(new HeapNode(nbr.node, nbr.node.srcDist));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        FastReader fr = new FastReader();
        int N = fr.nextInt();
        int M = fr.nextInt();
        int K = fr.nextInt();
        int Q = fr.nextInt();
        Graph g = new Graph(N+1);
        for (int i = 0; i < M; i++) {
            g.addEdge(fr.nextInt() - 1, fr.nextInt() - 1, fr.nextInt());
        }
        int[] examCenters = new int[K];
        for (int i = 0; i < K; i++) {
            int src = fr.nextInt();
            examCenters[i] = src - 1;
        }
        g.ssspDijkstra(examCenters);
        for (int i = 0; i < Q; i++) {
            System.out.println(g.nodes.get(fr.nextInt() - 1).srcDist);
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
