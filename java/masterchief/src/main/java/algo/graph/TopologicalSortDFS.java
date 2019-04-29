package algo.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TopologicalSortDFS {
    static class Node {
        int num;
        boolean visited = false;
        boolean isRoot = true;
        List<Node> nbrs = new ArrayList<>();
        Node(int num){
            this.num = num;
        }
        void reset() {
            this.visited = false;
            this.isRoot = false;
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

        void resetAllNodes() {
            nodes.forEach(Node::reset);
        }

        void markRootNodes() {
            nodes.forEach(n -> n.isRoot = true);
            nodes.forEach(node -> node.nbrs.forEach(nbr -> nbr.isRoot = false));
        }

        void topologicalSortWithComponents() {
            markRootNodes();
            List<List<Node>> topoSortedLists = new ArrayList<>();
            for (Node node : nodes) {
                if (node.isRoot) {
                    List<Node> sortedList = new ArrayList<>();
                    topologicalSort(node, sortedList);
                    Collections.reverse(sortedList);
                    topoSortedLists.add(sortedList);
                }
            }
            for (List<Node> topoSortedList : topoSortedLists) {
                System.out.println(topoSortedList.stream().map(n -> n.num + "")
                        .collect(Collectors.joining(" ")));
            }
        }

        void topologicalSortWithoutComponents() {
            List<Node> topologicalSort = new ArrayList<>();
            for (Node node : nodes) {
                if (!node.visited) {
                    List<Node> sortedList = new ArrayList<>();
                    topologicalSort(node, sortedList);
                    topologicalSort.addAll(sortedList);
                }
            }
            Collections.reverse(topologicalSort);
            System.out.println(topologicalSort.stream()
                    .map(node -> node.num + "").collect(Collectors.joining(" ")));
        }

        void topologicalSort(Node rootNode, List<Node> topoSorted) {
            rootNode.visited = true;
            for (Node nbrNode : rootNode.nbrs) {
                if (!nbrNode.visited) {
                    topologicalSort(nbrNode, topoSorted);
                }
            }
            topoSorted.add(rootNode);
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(8);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(2, 5);
        g.addEdge(3, 4);
        g.addEdge(7, 6);
        g.topologicalSortWithComponents();
        g.resetAllNodes();
        g.topologicalSortWithoutComponents();
    }

}
