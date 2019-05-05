package hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BoozeFirst {
    static class Nbr {
        public Node node;
        public int weight;

        public Nbr(Node node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    static class Node {
        public int num;
        public int srcDist;
        public List<Nbr> nbrs = new ArrayList<>();

        public Node(int num) {
            this.num = num;
            this.srcDist = Integer.MAX_VALUE;
        }
    }

    static class HeapNode implements Comparable<HeapNode> {
        public int distance;
        public Node node;

        public HeapNode(Node node, int distance) {
            this.node = node;
            this.distance = distance;
        }
        @Override
        public int compareTo(HeapNode other) {
            return this.distance == other.distance
                    ? this.node.num - other.node.num
                    : this.distance - other.distance;
        }
    }

    static class Graph {
        List<Node> nodes;

        public Graph(int size) {
            nodes = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                nodes.add(new Node(i));
            }
        }

        public void addEdge(int m, int n, int weight) {
            Node node1 = nodes.get(m);
            Node node2 = nodes.get(n);
            node1.nbrs.add(new Nbr(node2, weight));
            node2.nbrs.add(new Nbr(node1, weight));
        }

        public void ssspDijkstra(int[] sources) {
            PriorityQueue<HeapNode> pq = new PriorityQueue<>();
            for (int src : sources) {
                Node node = nodes.get(src);
                node.srcDist = 0;
                pq.add(new HeapNode(node, 0));
            }
            while (!pq.isEmpty()) {
                HeapNode front = pq.remove();
                if (front.distance > front.node.srcDist) {
                    continue;
                }
                for (Nbr nbr : front.node.nbrs) {
                    if (front.node.srcDist + nbr.weight < nbr.node.srcDist) {
                        nbr.node.srcDist = front.node.srcDist + nbr.weight;
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
        Graph graph = new Graph(N);
        for (int i = 0; i < M; i++) {
            graph.addEdge(fr.nextInt() - 1, fr.nextInt() - 1, fr.nextInt());
        }
        int B = fr.nextInt();
        int[] boozeSources = new int[B];
        for (int i = 0; i < B; i++) {
            boozeSources[i] = fr.nextInt() - 1;
        }
        graph.ssspDijkstra(boozeSources);

        for (Node node : graph.nodes) {
            System.out.println(node.srcDist);
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
