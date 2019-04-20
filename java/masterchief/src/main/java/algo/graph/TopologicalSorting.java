package algo.graph;

// TODO
public class TopologicalSorting {

    public int[] topologicalBfs(int n, int[][] adj) {
        int[] T = new int[n];
        int[] visited = new int[n];
        int[] inDegree = new int[n];

        for (int i = 0; i < n; i++) {
            inDegree[i] = visited[i] = 0;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
    }
}
