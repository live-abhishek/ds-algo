package algo.graph;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BFS {
    static class Node{
        int num; int d = 0;
        List<Node> nbrs = new ArrayList<>();
        Node(int n) { this.num = n; }
        public String toString(){
            return String.format("%d: %s", num, nbrs.stream()
                    .map(n -> n.num+"")
                    .collect(Collectors.joining(" ")));
        }
    }
    static class Graph{
        List<Node> nodes = new ArrayList<>();
        Graph(int size){ IntStream.range(0, size)
                .forEach(i -> nodes.add(new Node(i))); }
        void addNbr(int nodeNum, int... nbrs){
            Arrays.stream(nbrs)
                    .forEach(i -> nodes.get(nodeNum).nbrs.add(nodes.get(i)));
        }
        public String toString(){
            return nodes.stream()
                    .map(n -> n.toString())
                    .collect(Collectors.joining("\n"));
        }
        List<List<Node>> bfs(){
            List<List<Node>> forest = new ArrayList<>();
            nodes.forEach(n -> n.d = -1);

            for(Node start: nodes){
                if(start.d != -1){
                    continue;
                }
                start.d = 0;
                Queue<Node> q = new LinkedList<>();
                q.offer(start);
                List<Node> tree = new ArrayList<>();
                while(!q.isEmpty()){
                    Node node = q.poll();
                    tree.add(node);
                    for(Node nbr : node.nbrs){
                        if(nbr.d == -1){
                            nbr.d = node.d + 1;
                            q.offer(nbr);
                        }
                    }
                }
                forest.add(tree);
            }
            return forest;
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(9);
        g.addNbr(0, 1);
        g.addNbr(1, 0, 2, 3);
        g.addNbr(2, 1, 3);
        g.addNbr(3, 1, 2, 4);
        g.addNbr(4, 3);
        g.addNbr(5);
        g.addNbr(6, 7, 8);
        g.addNbr(7, 6);
        g.addNbr(8, 6);
        g.bfs().forEach(t -> {
            System.out.println();
            t.forEach(n -> System.out.println(n));
        });
    }
}
