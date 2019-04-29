package algo.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class SccTarjan {
    static class Node {
        int num;
        int dfsNum = -1;
        int dfsLow = -1;
        List<Node> nbrs = new ArrayList<>();

        Node(int num) {
            this.num = num;
        }
    }

    static class Graph {
        int dfsNumCounter = 0;
        int numScc = 0;
        Stack<Node> stk = new Stack<>();
        List<Node> nodes = new ArrayList<>();

        Graph(int size) {
            nodes = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                nodes.add(new Node(i));
            }
        }

        void addEdge(int u, int v) {
            nodes.get(u).nbrs.add(nodes.get(v));
        }

        void findScc() {
            List<List<Node>> components = new ArrayList<>();
            for (Node node : nodes) {
                if (node.dfsNum == -1) {
                    findSccTarjan(node, components);
                }
            }
            for (List<Node> component : components) {
                System.out.println(component.stream().map(n -> n.num+"")
                        .collect(Collectors.joining(" ")));
            }
        }

        void findSccTarjan(Node rootNode, List<List<Node>> components) {
            rootNode.dfsNum = rootNode.dfsLow = dfsNumCounter;
            dfsNumCounter++;
            stk.push(rootNode);
            for (Node node : rootNode.nbrs) {
                if (node.dfsNum == -1) {
                    findSccTarjan(node, components);
                }
                rootNode.dfsLow = Integer.min(rootNode.dfsLow, node.dfsLow);
            }
            if (rootNode.dfsLow == rootNode.dfsNum) {
                numScc++;
                List<Node> component = new ArrayList<>();
                while (true) {
                    Node node = stk.pop();
                    component.add(node);
                    if (rootNode == node) {
                        break;
                    }
                }
                components.add(component);
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(8);
        g.addEdge(0, 1);
        g.addEdge(1, 3);
        g.addEdge(3, 2);
        g.addEdge(2, 1);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        g.addEdge(5, 7);
        g.addEdge(7, 6);
        g.addEdge(6, 4);
        g.findScc();
    }

}
