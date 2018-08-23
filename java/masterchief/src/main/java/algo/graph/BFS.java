package algo.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class BFS {
    static class Node{
        int num; int d = 0;
        List<Node> nbrs = new ArrayList<>();
        Node(int n) { this.num = n; }
    }
    static class Graph{
        List<Node> nodes = new ArrayList<>();
        Graph(int size){ IntStream.range(0, size).forEach(i -> nodes.add(new Node(i))); }
        void addNbr(int nodeNum, int... nbrs){
            // TODO: complete this
        }
    }
}
