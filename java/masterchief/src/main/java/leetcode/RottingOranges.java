package leetcode;


import java.util.LinkedList;

public class RottingOranges {
    static class Node{
        int state;
        int row;
        int col;
        boolean visited = false;
        int d = 0;

        Node(int state, int row, int col) {
            this.state = state;
            this.row = row;
            this.col = col;
        }
    }
    public int orangesRotting(int[][] grid) {
        Node[][] nodes = new Node[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                nodes[i][j] = new Node(grid[i][j], i, j);
            }
        }
        LinkedList<Node> nodeQ = new LinkedList<>();
        for (int i = 0; i < nodes.length; i++) {
            for (int j = 0; j < nodes[i].length; j++) {
                if (nodes[i][j].state == 2) {
                    nodeQ.add(nodes[i][j]);
                }
            }
        }
        bfs(nodes, nodeQ);
        int maxTime = 0;
        for (int i = 0; i < nodes.length; i++) {
            for (int j = 0; j < nodes[i].length; j++) {
                if (nodes[i][j].state == 1) {
                    return -1;
                }
                maxTime = Integer.max(maxTime, nodes[i][j].d);
            }
        }
        return maxTime;
    }

    private void bfs(Node[][] nodes, LinkedList<Node> nodeQ) {
        while (!nodeQ.isEmpty()) {
            Node currNode = nodeQ.removeFirst();
            // add left node is left node is present
            if (currNode.col > 0) {
                Node leftNode = nodes[currNode.row][currNode.col - 1];
                checkAndAddNodeToQueue(leftNode, nodeQ, currNode.d);
            }
            // similar for right node
            if (currNode.col < nodes[0].length - 1) {
                Node rightNoe = nodes[currNode.row][currNode.col + 1];
                checkAndAddNodeToQueue(rightNoe, nodeQ, currNode.d);
            }
            // upper node
            if (currNode.row > 0) {
                Node upperNode = nodes[currNode.row - 1][currNode.col];
                checkAndAddNodeToQueue(upperNode, nodeQ, currNode.d);
            }
            // lower node
            if (currNode.row < nodes.length - 1) {
                Node lowerNode = nodes[currNode.row + 1][currNode.col];
                checkAndAddNodeToQueue(lowerNode, nodeQ, currNode.d);
            }
        }
    }

    private void checkAndAddNodeToQueue(Node node, LinkedList queue, int d) {
        if(node.state == 1 && !node.visited) {
            node.state = 2;
            node.visited = true;
            node.d = d + 1;
            queue.add(node);
        }
    }
}
