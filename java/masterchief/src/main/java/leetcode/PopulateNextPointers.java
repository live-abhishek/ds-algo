package leetcode;

import java.util.LinkedList;

public class PopulateNextPointers {
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val,Node _left,Node _right,Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
    static class QueueNode {
        public Node node;
        public int level;

        public QueueNode(Node node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public Node connect(Node root) {
        if(root != null) {
            processTree(root);
        }
        return root;
    }

    private void processTree(Node root) {
        LinkedList<QueueNode> queue = new LinkedList<>();
        queue.add(new QueueNode(root, 0));
        QueueNode prevQueueNode = null;
        while (!queue.isEmpty()) {
            QueueNode currQueueNode = queue.removeFirst();
            if (prevQueueNode != null && prevQueueNode.level == currQueueNode.level) {
                prevQueueNode.node.next = currQueueNode.node;
            }
            if (currQueueNode.node.left != null) {
                queue.add(new QueueNode(currQueueNode.node.left, currQueueNode.level + 1));
            }
            if (currQueueNode.node.right != null) {
                queue.add(new QueueNode(currQueueNode.node.right, currQueueNode.level + 1));
            }
            prevQueueNode = currQueueNode;
        }
    }
}
