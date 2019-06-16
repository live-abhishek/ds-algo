package codingInterview.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeBoundary {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static List<TreeNode> findBoundary(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        List<TreeNode> leftView = new ArrayList<>();
        List<TreeNode> rightView = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode currNode = queue.poll();
                if (currNode.left == null && currNode.right == null) {
                    continue;
                }
                if (i == 0) {
                    leftView.add(currNode);
                }
                if (i > 0 && i == size - 1) {
                    rightView.add(0, currNode);
                }
                if (currNode.left != null) {
                    queue.offer(currNode.left);
                }
                if (currNode.right != null) {
                    queue.offer(currNode.right);
                }
            }
        }
        List<TreeNode> baseView = new ArrayList<>();
        findBase(root, baseView);
        result.addAll(leftView);
        result.addAll(baseView);
        result.addAll(rightView);
        return result;
    }

    public static void findBase(TreeNode root, List<TreeNode> baseList){
        if (root.left == null && root.right == null) {
            baseList.add(root);
            return;
        }
        if (root.left != null) {
            findBase(root.left, baseList);
        }
        if (root.right != null) {
            findBase(root.right, baseList);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(9);
        root.left.right = new TreeNode(3);
        root.left.right.left = new TreeNode(15);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.right.right.left = new TreeNode(6);
        List<TreeNode> result = TreeBoundary.findBoundary(root);
        for (TreeNode node : result) {
            System.out.print(node.val + " ");
        }
    }
}
