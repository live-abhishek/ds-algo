package codingInterview.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderSuccessor {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode findSuccessor(TreeNode root, int key) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode currNode = queue.poll();
            if (currNode.left != null) {
                queue.offer(currNode.left);
            }
            if (currNode.right != null) {
                queue.offer(currNode.right);
            }
            if (currNode.val == key) {
                break;
            }
        }
        return queue.peek();
    }

    public static TreeNode findSuccessorUsingPrevNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }
        TreeNode prevNode = null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode currNode = queue.poll();
            if (prevNode != null && prevNode.val == key) {
                return currNode;
            }
            if (currNode.left != null) {
                queue.offer(currNode.left);
            }
            if (currNode.right != null) {
                queue.offer(currNode.right);
            }
            prevNode = currNode;
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        TreeNode result = LevelOrderSuccessor.findSuccessor(root, 12);
        if (result != null)
            System.out.println(result.val + " ");
        result = LevelOrderSuccessor.findSuccessor(root, 9);
        if (result != null)
            System.out.println(result.val + " ");
    }
}
