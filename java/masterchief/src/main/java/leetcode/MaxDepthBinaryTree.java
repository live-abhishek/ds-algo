package leetcode;

public class MaxDepthBinaryTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Integer.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }
}
