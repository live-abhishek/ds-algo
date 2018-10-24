package algo.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

class UnionFind{
    int[] parent;
    int[] rank;
    UnionFind(int n){
        this.parent = new int[n];
        this.rank = new int[n];
    }
    void makeSet(int v) {
        parent[v] = v;
        rank[v] = 0;
    }
    int findSet(int v){
        if (v == parent[v]) {
            return v;
        }
        parent[v] = findSet(parent[v]);
        return parent[v];
    }
    void union(int a, int b){
        a = findSet(a);
        b = findSet(b);
        if (a != b) {
            if (rank[a] < rank[b]) {
                // swap a & b
                int t = a;
                a = b;
                b = t;
            }
            parent[b] = a;
            if (rank[a] == rank[b]) {
                rank[a]++;
            }
        }
    }
}

class Edge implements Comparable<Edge>{
    int u, v, wt;
    Edge(int u, int v, int wt) {
        this.u = u;
        this.v = v;
        this.wt = wt;
    }
    @Override
    public int compareTo(Edge o) {
        return this.wt - o.wt;
    }
}

class Graph {
    int n;
    List<Edge> edges = new ArrayList<>();
    List<Edge> result = new ArrayList<>();
    UnionFind uf;
    Graph(int n){
        // e.g. n == 6; then 7 nodes will be added;
        // node 0 is dummy node; will not participate
        this.n = n + 1;
        uf = new UnionFind(this.n);
        IntStream.range(0, this.n).forEach(i -> uf.makeSet(i));
    }
    void addEdge(int a, int b, int w){
        edges.add(new Edge(a, b, w));
    }
    List<Edge> mstKruskal(){
        int cost = 0;
        for(Edge e : edges){
            // if not in same set
            if(uf.findSet(e.u) != uf.findSet(e.v)){
                cost += e.wt;
                result.add(e);
                uf.union(e.u, e.v);
            }
        }
        return result;
    }
}

public class Kruskal{

    public static void main(String[] args) {
        // 6 nodes will be added from 1 to 6
        Graph g = new Graph(6);
        g.addEdge(1,4,1);
        g.addEdge(1,2,2);
        g.addEdge(1,5,4);
        g.addEdge(2,4,3);
        g.addEdge(2,3,3);
        g.addEdge(2,6,7);
        g.addEdge(3,4,5);
        g.addEdge(3,6,8);
        g.addEdge(4,5,9);
        List<Edge> resultEdges = g.mstKruskal();
        resultEdges.forEach(edge -> System.out.println(String.format("u:%d v:%d w:%d", edge.u, edge.v, edge.wt)));
    }
}
