package codingInterview.dfs;

public class MaximumPathSum {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static int maxSum = 0;

    public static int findMaximumPathSum(TreeNode root) {
        maxSum = 0;
        maxSum(root);
        return maxSum;
    }

    private static int maxSum(TreeNode root){
        if (root == null) {
            return 0;
        }
        int leftSum = maxSum(root.left);
        int rightSum = maxSum(root.right);
        maxSum = Integer.max(maxSum, leftSum + rightSum + root.val);
        return Integer.max(leftSum, rightSum) + root.val;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));
        root = new TreeNode(-1);
        root.left = new TreeNode(-3);
        System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));
    }
}
