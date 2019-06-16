package codingInterview.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectLevelOrderSiblings {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode next;

        TreeNode(int x) {
            val = x;
            left = right = next = null;
        }

        // level order traversal using 'next' pointer
        void printLevelOrder() {
            TreeNode nextLevelRoot = this;
            while (nextLevelRoot != null) {
                TreeNode current = nextLevelRoot;
                nextLevelRoot = null;
                while (current != null) {
                    System.out.print(current.val + " ");
                    if (nextLevelRoot == null) {
                        if (current.left != null)
                            nextLevelRoot = current.left;
                        else if (current.right != null)
                            nextLevelRoot = current.right;
                    }
                    current = current.next;
                }
                System.out.println();
            }
        }
    }

    public static void connect(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode currNode = queue.poll();
                if (currNode.left != null) {
                    queue.offer(currNode.left);
                }
                if (currNode.right != null) {
                    queue.offer(currNode.right);
                }
                if (i != size - 1) {
                    currNode.next = queue.peek();
                }
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        ConnectLevelOrderSiblings.connect(root);
        System.out.println("Level order traversal using 'next' pointer: ");
        root.printLevelOrder();
    }
}
