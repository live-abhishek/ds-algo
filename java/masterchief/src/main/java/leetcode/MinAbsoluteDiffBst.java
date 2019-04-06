package leetcode;

public class MinAbsoluteDiffBst {
    int minDiff = Integer.MAX_VALUE;
    TreeNode prevNode = null;
    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return minDiff;
    }

    public void inOrder(TreeNode root) {
        if (root.left != null) {
            inOrder(root.left);
        }
        if (prevNode != null) {
            minDiff = Integer.min(minDiff, root.val - prevNode.val);
        }
        prevNode = root;
        if (root.right != null) {
            inOrder(root.right);
        }
    }
}
