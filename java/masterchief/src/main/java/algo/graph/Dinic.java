package algo.graph;

import java.util.*;

public class Dinic {
    static class FlowEdge{
        int v, u;
        long cap, flow = 0;
        FlowEdge(int v, int u, long cap){
            this.v = v;
            this.u = u;
            this.cap = cap;
        }
    }

    final long FLOW_INF = Long.MAX_VALUE;
    List<FlowEdge> edges;
    List<List<Integer>> adj;
    int n, m = 0;
    int s, t;
    int[] level, ptr;
    Queue<Integer> q;

    Dinic(int n, int s, int t){
        this.n = n;
        this.s = s;
        this.t = t;
        edges = new ArrayList<>();
        adj = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        level = new int[n];
        ptr = new int[n];
        q = new ArrayDeque<>();
    }

    void addEdge(int v, int u, long cap) {
        edges.add(new FlowEdge(v, u, cap));
        edges.add(new FlowEdge(u, v, 0));
        adj.get(v).add(m);
        adj.get(u).add(m + 1);
        m += 2;
    }

    boolean bfs() {
        while (!q.isEmpty()) {
            int v = q.poll();
            for (int id : adj.get(v)) {
                if (edges.get(id).cap - edges.get(id).flow < 1) {
                    continue;
                }
                if (level[edges.get(id).u] != -1) {
                    continue;
                }
                level[edges.get(id).u] = level[v] + 1;
                q.add(edges.get(id).u);
            }
        }
        return level[t] != -1;
    }

    long dfs(int v, long pushed) {
        if (pushed == 0) {
            return 0;
        }
        if (v == t) {
            return pushed;
        }
        for (int cid = 0; cid < adj.get(v).size(); cid++) {
            int id = adj.get(v).get(cid);
            int u = edges.get(id).u;
            if (level[v] + 1 != level[u] || edges.get(id).cap - edges.get(id).flow < 1) {
                continue;
            }
            long tr = dfs(u, Long.min(pushed, edges.get(id).cap - edges.get(id).flow));
            if (tr == 0) {
                continue;
            }
            edges.get(id).flow += tr;
            edges.get(id ^ 1).flow -= tr;
            return tr;
        }
        return 0;
    }

    long flow() {
        long f = 0;
        while (true) {
            Arrays.fill(level, -1);
            level[s] = 0;
            q.add(s);
            if (!bfs()) {
                break;
            }
            Arrays.fill(ptr, 0);
            long pushed = dfs(s, FLOW_INF);
            while (pushed != 0) {
                f += pushed;
                pushed = dfs(s, FLOW_INF);
            }
        }
        return f;
    }

    public static void main(String[] args) {
        Dinic graph = new Dinic(6, 0, 5);
        graph.addEdge(0, 1, 16 );
        graph.addEdge(0, 2, 13 );
        graph.addEdge(1, 2, 10 );
        graph.addEdge(1, 3, 12 );
        graph.addEdge(2, 1, 4 );
        graph.addEdge(2, 4, 14);
        graph.addEdge(3, 2, 9 );
        graph.addEdge(3, 5, 20 );
        graph.addEdge(4, 3, 7 );
        graph.addEdge(4, 5, 4);

        /*
        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 2, 10);
        graph.addEdge(1, 2, 2);
        graph.addEdge(1, 3, 4);
        graph.addEdge(1, 4, 8);
        graph.addEdge(2, 4, 9);
        graph.addEdge(3, 5, 10);
        graph.addEdge(4, 5, 10);
        */
        long maxFlow = graph.flow();
        System.out.println(maxFlow);
    }
}
