package algo.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class TopologicalSortBFS {
    static class Node {
        int num;
        List<Node> nbrs = new ArrayList<>();
        boolean visited = false;
        boolean isRoot = false;
        int inDegree = 0;

        Node(int num) {
            this.num = num;
        }

        void reset() {
            this.visited = false;
            this.inDegree = 0;
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

        void addEdge(int u, int v) {
            nodes.get(u).nbrs.add(nodes.get(v));
        }

        public void resetAllNodes() {
            nodes.forEach(Node::reset);
        }

        void markRootNodes() {
            nodes.forEach(node -> node.isRoot = true);
            nodes.forEach(node -> node.nbrs.forEach(nbr -> nbr.isRoot = false));
        }

        void calculateInDegrees() {
            nodes.forEach(node -> node.nbrs.forEach(nbr -> nbr.inDegree += 1));
        }

        public void topologicalSortWithComponents() {
            markRootNodes();
            calculateInDegrees();
            List<List<Node>> topoSortedLists = new ArrayList<>();
            for (Node node : nodes) {
                if (node.isRoot) {
                    List<Node> topologicalSort = topologicalSort(node);
                    topoSortedLists.add(topologicalSort);
                }
            }
            for (List<Node> topoSortedList : topoSortedLists) {
                System.out.println(topoSortedList.stream().map(n -> n.num + "")
                        .collect(Collectors.joining(" ")));
            }
        }

        List<Node> topologicalSort(Node node) {
            List<Node> topoSortedList = new ArrayList<>();
            node.visited = true;
            Queue<Node> queue = new ArrayDeque<>();
            queue.add(node);
            while (!queue.isEmpty()) {
                Node currNode = queue.remove();
                topoSortedList.add(currNode);
                for (Node nbr : currNode.nbrs) {
                    if (!nbr.visited) {
                        nbr.inDegree -= 1;
                        if (nbr.inDegree == 0) {
                            nbr.visited = true;
                            queue.add(nbr);
                        }
                    }
                }
            }
            return  topoSortedList;
        }
    }

    public static void main(String[] args) {
        Graph g1 = new Graph(6);
        g1.addEdge(0, 1);
        g1.addEdge(0, 3);
        g1.addEdge(1, 2);
        g1.addEdge(1, 3);
        g1.addEdge(2, 3);
        g1.addEdge(2, 4);
        g1.addEdge(2, 5);
        g1.addEdge(3, 4);
        g1.addEdge(3, 5);
        g1.addEdge(4, 5);
        g1.topologicalSortWithComponents();

        TopologicalSortDFS.Graph g2 = new TopologicalSortDFS.Graph(8);
        g2.addEdge(0, 1);
        g2.addEdge(0, 2);
        g2.addEdge(1, 2);
        g2.addEdge(1, 3);
        g2.addEdge(2, 3);
        g2.addEdge(2, 5);
        g2.addEdge(3, 4);
        g2.addEdge(7, 6);
        g2.topologicalSortWithComponents();

    }

}
