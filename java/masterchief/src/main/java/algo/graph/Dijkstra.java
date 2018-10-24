package algo.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class Dijkstra {
    static class Nbr{
        public Node node;
        public int distance;
        public Nbr(Node node, int distance){
            this.node = node;
            this.distance = distance;
        }
    }
    static class Node{
        public int num;
        public int srcDist;
        public List<Nbr> nbrs = new ArrayList<>();
        public Node(int i){this.num = i;}
    }

    // this instances of this class will be used in Dijkstra Heap
    static class HeapNode implements  Comparable<HeapNode>{
        // this is distance from the current node
        public int distance;
        // this is one of the neighbouring node of the current node
        public Node node;
        public HeapNode(int distance, Node node){
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

    static class Graph{
        public List<Node> nodes = new ArrayList<>();
        public Graph(int num){
            IntStream.range(0, num).forEach(i -> nodes.add(new Node(i)));
        }
        public void addEdge(int m, int n, int distance){
            Node node1 = nodes.get(m);
            Node node2 = nodes.get(n);
            node1.nbrs.add(new Nbr(node2, distance));
        }
        private void resetNodeDistance(){
            nodes.forEach(node -> node.srcDist = Integer.MAX_VALUE);
        }
        public void dijkstra(int s){
            resetNodeDistance();
            Node source = nodes.get(s);
            source.srcDist = 0;
            PriorityQueue<HeapNode> pq = new PriorityQueue<>();
            pq.add(new HeapNode(0, source));
            while (!pq.isEmpty()) {
                HeapNode front = pq.remove();
                if(front.distance > front.node.srcDist) continue;
                for(Nbr nbr: front.node.nbrs){
                    if(front.node.srcDist + nbr.distance < nbr.node.srcDist){
                        nbr.node.srcDist = front.node.srcDist + nbr.distance;
                        pq.add(new HeapNode(nbr.node.srcDist, nbr.node));
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        // Example consists of a directed graph
        Graph graph = new Graph(5);
        graph.addEdge(2,1,2);
        graph.addEdge(2,3,7);
        graph.addEdge(1,3,3);
        graph.addEdge(2,0,6);
        graph.addEdge(1,4,6);
        graph.addEdge(0,4,1);
        graph.addEdge(3,4,5);
        graph.dijkstra(2);
        graph.nodes.forEach(node -> System.out.println(node.num + " " + node.srcDist));
    }
}