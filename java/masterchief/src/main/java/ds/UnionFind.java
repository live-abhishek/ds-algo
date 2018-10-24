package ds;

import java.util.Random;
import java.util.stream.IntStream;

public class UnionFind {
    int[] parent;
    int[] size;
    int[] rank;
    public UnionFind(int n){
        this.parent = new int[n];
        this.size = new int[n];
        this.rank = new int[n];
    }
    public void makeSet(int v){
        parent[v] = v;
        size[v] = 1;
        rank[v] = 0;
    }
    public int findSet(int v){
        return findSetPathCompression(v);
    }
    private int findSetNormal(int v){
        if (v == parent[v]) {
            return v;
        }
        return findSetNormal(parent[v]);
    }
    private int findSetPathCompression(int v){
        if (v == parent[v]) {
            return v;
        }
        parent[v] = findSetPathCompression(parent[v]);
        return parent[v];
    }
    public void unionSet(int a, int b){
        unionByRank(a, b);
    }
    private void unionSetNormal(int a, int b){
        a = findSet(a);
        b = findSet(b);
        if (a != b) {
            parent[b] = a;
        }
    }
    private void unionBySize(int a, int b) {
        a = findSet(a);
        b = findSet(b);
        if (a != b) {
            if (size[a] < size[b]) {
                // swap a & b
                int t = a;
                a = b;
                b = t;
            }
            parent[b] = a;
            size[a] += size[b];
        }
    }
    private void unionByRank(int a, int b) {
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
    private void unionRandomizedLinking(int a, int b) {
        a = findSet(a);
        b = findSet(b);
        if (a != b) {
            if (new Random().nextInt() % 2 == 1) {
                // swap a & b
                int t = a;
                a = b;
                b = t;
            }
            parent[b] = a;
        }
    }
    public static void main(String[] args) {
        int n = 5;
        UnionFind uf = new UnionFind(n);
        IntStream.range(0, n).forEach(i -> uf.makeSet(i));
        uf.unionSet(1, 2);
        int parent = uf.findSet(1);
        System.out.println(parent);
        parent = uf.findSet(2);
        System.out.println(parent);
        uf.unionSet(3, 4);
        uf.unionSet(4, 1);
        parent = uf.findSet(1);
        System.out.println(parent);
        parent = uf.findSet(2);
        System.out.println(parent);
        parent = uf.findSet(3);
        System.out.println(parent);
        parent = uf.findSet(4);
        System.out.println(parent);
    }
}
