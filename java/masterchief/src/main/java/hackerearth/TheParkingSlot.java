package hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TheParkingSlot {
    static class Nbr {
        Node node;
        long weight;

        Nbr(Node node, long weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    static class Node {
        List<Nbr> nbrs = new ArrayList<>();
        int num;
        int capacity;
        long srcDist = Long.MAX_VALUE;

        Node(int num, int capacity) {
            this.num = num;
            this.capacity = capacity;
        }
    }

    static class HeapNode implements Comparable<HeapNode> {
        long dist;
        Node node;

        HeapNode(Node node, long dist) {
            this.node = node;
            this.dist = dist;
        }
        @Override
        public int compareTo(HeapNode other) {
            return this.dist == other.dist
                    ? this.node.num - other.node.num
                    : (int)(this.dist - other.dist);
        }
    }

    static class Graph {
        List<Node> nodes;

        Graph(int size, int[] capacity) {
            nodes = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                nodes.add(new Node(i, capacity[i]));
            }
        }

        void addEdge(int u, int v, long w) {
            Node node1 = nodes.get(u);
            Node node2 = nodes.get(v);
            node1.nbrs.add(new Nbr(node2, w));
            node2.nbrs.add(new Nbr(node1, w));
        }

        void ssspDijkstra(int source) {
            PriorityQueue<HeapNode> pq = new PriorityQueue<>();
            Node sourceNode = nodes.get(source);
            sourceNode.srcDist = 0;
            pq.add(new HeapNode(sourceNode, 0));
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
        int F = fr.nextInt();
        int[] capacity = new int[N];
        for (int i = 0; i < N; i++) {
            capacity[i] = fr.nextInt();
        }
        Graph g = new Graph(N, capacity);
        for (int i = 0; i < M; i++) {
            g.addEdge(fr.nextInt() - 1, fr.nextInt() - 1, fr.nextLong());
        }
        g.ssspDijkstra(0);
        int K = fr.nextInt();
        StringBuilder sb = new StringBuilder();
        int currNodeIndex = 0;
        g.nodes.sort(Comparator.comparingLong(n -> n.srcDist));
        for (int i = 0; i < K; i++) {
            if (currNodeIndex < g.nodes.size()) {
                Node currNode = g.nodes.get(currNodeIndex);
                sb.append(F + currNode.srcDist).append(" ");
                currNode.capacity--;
                if (currNode.capacity == 0) {
                    currNodeIndex++;
                }
            } else {
                sb.append(-1).append(" ");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
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
