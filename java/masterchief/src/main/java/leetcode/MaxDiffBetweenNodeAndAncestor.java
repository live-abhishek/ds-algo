package leetcode;

public class MaxDiffBetweenNodeAndAncestor {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    int maxDiff = -1;
    public int maxAncestorDiff(TreeNode root) {
        traverse(root, root.val, root.val);
        return maxDiff;
    }

    private void traverse(TreeNode root, int min, int max){
        maxDiff = Integer.max(Integer.max(Math.abs(root.val - min), Math.abs(root.val - max)), maxDiff);
        if(root.left != null) {
            traverse(root.left, Integer.min(min, root.left.val), Integer.max(max, root.left.val));
        }
        if(root.right != null) {
            traverse(root.right, Integer.min(min, root.right.val), Integer.max(max, root.right.val));
        }
    }

}
