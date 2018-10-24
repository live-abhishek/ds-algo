package algo.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class Prim {
    public static class Nbr{
        public int distance;
        public Node node;
        public Nbr(int distance, Node node){
            this.distance = distance;
            this.node = node;
        }
    }
    public static class Node{
        public int num;
        public List<Nbr> nbrs = new ArrayList<>();
        public boolean taken;
        public Node(int num){
            this.num = num;
        }
    }
    public static class HeapNode implements Comparable<HeapNode>{
        // distance from current node
        public int distance;
        // one of the neighbour node of the current node
        public Node node;
        public HeapNode(int distance, Node node){
            this.node = node;
            this.distance = distance;
        }
        @Override
        public int compareTo(HeapNode o) {
            return this.distance == o.distance
                    ? this.node.num - o.node.num
                    : this.distance - o.distance;
        }
    }
    public static class Graph{
        public List<Node> nodes = new ArrayList<>();
        public Graph(int num){
            IntStream.range(0,num).forEach(i -> nodes.add(new Node(i)));
        }
        public void addEdge(int m, int n, int dist){
            Node node1 = nodes.get(m);
            Node node2 = nodes.get(n);
            node1.nbrs.add(new Nbr(dist, node2));
            node2.nbrs.add(new Nbr(dist, node1));
        }
        private void process(Node node, PriorityQueue pq){
            node.taken = true;
            for (Nbr nbr : node.nbrs) {
                if(!nbr.node.taken){
                    pq.add(new HeapNode(nbr.distance, nbr.node));
                }
            }
        }
        public int prim(){
            PriorityQueue<HeapNode> pq = new PriorityQueue<>();
            process(nodes.get(0), pq);
            int mstCost = 0;
            while (!pq.isEmpty()) {
                HeapNode front = pq.remove();
                if (!front.node.taken) {
                    mstCost += front.distance;
                    process(front.node, pq);
                }
            }
            return mstCost;
        }
    }
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0,1,4);
        graph.addEdge(0,2,4);
        graph.addEdge(1,2,2);
        graph.addEdge(2,3,8);
        graph.addEdge(0,3,6);
        graph.addEdge(0,4,6);
        graph.addEdge(3,4,9);
        int mstCost = graph.prim();
        System.out.println(mstCost);    
    }
}
