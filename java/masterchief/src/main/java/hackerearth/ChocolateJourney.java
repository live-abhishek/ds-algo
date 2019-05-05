package hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class ChocolateJourney {
    static class Nbr {
        Node node;
        int weight;

        Nbr(Node node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    static class Node {
        List<Nbr> nbrs = new ArrayList<>();
        int num;
        int distFromA = Integer.MAX_VALUE;
        int distFromB = Integer.MAX_VALUE;
        boolean isChoclateCity = false;

        Node(int num) {
            this.num = num;
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
        public int compareTo(HeapNode other) {
            return this.dist == other.dist
                    ? this.node.num - other.node.num
                    : this.dist - other.dist;
        }
    }

    static class Graph {
        List<Node> nodes;

        Graph(int size) {
            this.nodes = new ArrayList<>(size);
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

        void ssspDijkstraA(int source) {
            PriorityQueue<HeapNode> pq = new PriorityQueue<>();
            Node sourceNode = nodes.get(source);
            sourceNode.distFromA = 0;
            pq.add(new HeapNode(sourceNode, 0));
            while (!pq.isEmpty()) {
                HeapNode currNode = pq.remove();
                if (currNode.dist > currNode.node.distFromA) {
                    continue;
                }
                for (Nbr nbr : currNode.node.nbrs) {
                    if (currNode.node.distFromA + nbr.weight < nbr.node.distFromA) {
                        nbr.node.distFromA = currNode.node.distFromA + nbr.weight;
                        pq.add(new HeapNode(nbr.node, nbr.node.distFromA));
                    }
                }
            }
        }

        void ssspDijkstraB(int source) {
            PriorityQueue<HeapNode> pq = new PriorityQueue<>();
            Node sourceNode = nodes.get(source);
            sourceNode.distFromB = 0;
            pq.add(new HeapNode(sourceNode, 0));
            while (!pq.isEmpty()) {
                HeapNode currNode = pq.remove();
                if (currNode.dist > currNode.node.distFromB) {
                    continue;
                }
                for (Nbr nbr : currNode.node.nbrs) {
                    if (currNode.node.distFromB + nbr.weight < nbr.node.distFromB) {
                        nbr.node.distFromB = currNode.node.distFromB + nbr.weight;
                        pq.add(new HeapNode(nbr.node, nbr.node.distFromB));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        FastReader fr = new FastReader();
        int N = fr.nextInt();
        int M = fr.nextInt();
        int k = fr.nextInt();
        int x = fr.nextInt();
        Graph g = new Graph(N);
        for (int i = 0; i < k; i++) {
            int city = fr.nextInt() - 1;
            g.nodes.get(city).isChoclateCity = true;
        }
        for (int i = 0; i < M; i++) {
            g.addEdge(fr.nextInt() - 1, fr.nextInt() - 1, fr.nextInt());
        }
        int A = fr.nextInt() - 1;
        int B = fr.nextInt() - 1;
        g.ssspDijkstraA(A);
        g.ssspDijkstraB(B);
        long totalDistance = Long.MAX_VALUE;
        List<Node> reachableChocolateCities = g.nodes.stream()
                .filter(n -> n.isChoclateCity)
                .filter(n -> n.distFromA != Integer.MAX_VALUE)
                .filter(n -> n.distFromB != Integer.MAX_VALUE)
//                .filter(n -> n.distFromA <= x)
                .collect(Collectors.toList());
        for (Node node : reachableChocolateCities) {
            totalDistance = Long.min(totalDistance, node.distFromA + node.distFromB);
        }
        System.out.println(totalDistance != Long.MAX_VALUE ? totalDistance : -1);
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
