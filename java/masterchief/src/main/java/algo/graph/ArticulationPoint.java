package algo.graph;

import java.util.ArrayList;
import java.util.List;

public class ArticulationPoint {
    static class Node {
        int num;
        int dfsNum = -1;
        int dfsLow = -1;
        boolean articulationPoint = false;
        Node parent = null;
        List<Node> nbrs = new ArrayList<>();
        Node(int n) {
            this.num = n;
        }

        @Override
        public String toString() {
            return num + "";
        }
    }

    static class Edge {
        int u , v;
        Edge(int u, int v) {
            this.u = u;
            this.v = v;
        }
    }

    static class Graph {
        List<Node> nodes;
        int dfsNumCounter = 0;

        Graph(int size) {
            nodes = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                nodes.add(new Node(i));
            }
        }

        void addEdge(int u, int v) {
            nodes.get(u).nbrs.add(nodes.get(v));
            if (u != v) {
                nodes.get(v).nbrs.add(nodes.get(u));
            }
        }

        void articulationPointAndBridge() {
            List<Edge> edges = new ArrayList<>();
            for (Node node : nodes) {
                if (node.dfsNum == -1) {
                    List<Edge> edgeList = articulationPointAndBridge(node);
                    edges.addAll(edgeList);
                }
            }
            System.out.println("Articulation Point:");
            for (Node node : nodes) {
                if (node.articulationPoint) {
                    System.out.println(node.num);
                }
            }
            System.out.println("Articulation Bridges:");
            for (Edge edge : edges) {
                System.out.println(edge.u + " " + edge.v);
            }
        }

        private List<Edge> articulationPointAndBridge(Node rootNode) {
            List<Edge> articulationEdges = new ArrayList<>();
            articulationPointAndBridge(rootNode, articulationEdges);
            if (rootNode.nbrs.size() > 1) {
                rootNode.articulationPoint = true;
            } else {
                rootNode.articulationPoint = false;
            }
            return articulationEdges;
        }

        private void articulationPointAndBridge(Node rootNode, List<Edge> edges) {
            rootNode.dfsNum = rootNode.dfsLow = dfsNumCounter;
            dfsNumCounter++;
            for (Node node : rootNode.nbrs) {
                if (node.dfsNum == -1) {
                    node.parent = rootNode;
                    articulationPointAndBridge(node, edges);
                    if (node.dfsLow >= rootNode.dfsNum) {
                        rootNode.articulationPoint = true;
                    }
                    if (node.dfsLow > rootNode.dfsNum) {
                        edges.add(new Edge(rootNode.num, node.num));
                    }
                    rootNode.dfsLow = Integer.min(rootNode.dfsLow, node.dfsLow);
                } else if(node != rootNode.parent) {
                    rootNode.dfsLow = Integer.min(rootNode.dfsLow, node.dfsNum);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph g1 = new Graph(6);
        g1.addEdge(0, 1);
        g1.addEdge(1, 2);
        g1.addEdge(1, 4);
        g1.addEdge(3, 4);
        g1.addEdge(4, 5);
        g1.articulationPointAndBridge();
        System.out.println();
        Graph g2 = new Graph(6);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        g2.addEdge(1, 4);
        g2.addEdge(1, 3);
        g2.addEdge(4, 5);
        g2.addEdge(1, 5);
        g2.articulationPointAndBridge();
    }
}
