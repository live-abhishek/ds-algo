package algo.graph;

import java.util.*;
import java.util.stream.IntStream;

public class Bipartite {

    enum GraphColor{
        red, green, None
    }

    static class Node implements Comparable<Node>{
        public int num;
        public GraphColor color;
        public List<Node> nbrs = new ArrayList<>();

        public Node(int num){
            this.num = num;
            this.color = GraphColor.None;
        }
        @Override
        public int hashCode() { return Objects.hash(num); }
        @Override
        public int compareTo(Node o){ return this.num - o.num; }
        @Override
        public boolean equals(Object o){ return this.num == ((Node)o).num; }
    }

    static class Graph{
        public List<Node> nodes = new ArrayList<>();

        public Graph(int size){
            IntStream.range(0, size).forEach(i -> nodes.add(null));
        }
        public void addNode(int nodeNum){
            if(nodeNum >= nodes.size()) {
                throw new RuntimeException("Invalid argument");
            }
            nodes.set(nodeNum, new Node(nodeNum));
        }
        public void addEdge(int nodeNum1, int nodeNum2){
            if(nodes.get(nodeNum1) == null) { addNode(nodeNum1); }
            if(nodes.get(nodeNum2) == null) { addNode(nodeNum2); }
            Node node1 = nodes.get(nodeNum1);
            Node node2 = nodes.get(nodeNum2);
            node1.nbrs.add(node2);
            node2.nbrs.add(node1);
        }

        public boolean isBipartite(){
            boolean isBipartite = true;
            nodes.forEach(node -> node.color = GraphColor.None);
            nodes.get(0).color = GraphColor.red;
            Queue<Node> q = new LinkedList<>(); q.offer(nodes.get(0));

            while(!q.isEmpty()){
                Node node = q.poll();
                for(Node nbr: node.nbrs){
                    if(nbr.color == GraphColor.None){
                        nbr.color = node.color == GraphColor.red
                                ? GraphColor.green
                                : GraphColor.red;
                        q.offer(nbr);
                    } else if(nbr.color == node.color){
                        isBipartite = false;
                        break;
                    }
                }
            }
            return isBipartite;
        }
    }

    public static void main(String[] args) {
        // not bipartite
        Graph graph = new Graph(13);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(0, 4);
        graph.addEdge(1, 5);
        graph.addEdge(2, 6);
        graph.addEdge(3, 7);
        graph.addEdge(5, 6);
        graph.addEdge(4, 8);
        graph.addEdge(8, 9);
        graph.addEdge(5, 10);
        graph.addEdge(6, 11);
        graph.addEdge(7, 12);
        graph.addEdge(9, 10);
        graph.addEdge(10, 11);
        graph.addEdge(11, 12);
        System.out.println(graph.isBipartite());

        // it is bipartite
        Graph graph2 = new Graph(4);
        graph2.addEdge(0, 1);
        graph2.addEdge(0, 3);
        graph2.addEdge(1, 2);
        graph2.addEdge(2, 3);
        System.out.println(graph2.isBipartite());
    }
}
