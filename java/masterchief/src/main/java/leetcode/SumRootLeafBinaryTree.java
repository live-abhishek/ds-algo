package leetcode;

public class SumRootLeafBinaryTree {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    int MOD = 1000000007;
    public int sumRootToLeaf(TreeNode root) {
        return helper(root, 0);
    }

    private int helper(TreeNode root, int val) {
        if (root == null) {
            return 0;
        }
        val = ((val << 1) + root.val) % MOD;
        if (root.left == root.right) {
            return val;
        }
        return (helper(root.left, val) + helper(root.right, val)) % MOD;
    }
}
