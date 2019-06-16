package codingInterview.dfs;

public class SumOfPathNumbers {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static int sum = 0;

    public static int findSumOfPathNumbers(TreeNode root) {
        findPath(root, 0);
        return sum;
    }

    private static void findPath(TreeNode root, int currSum){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            int pathSum = currSum * 10 + root.val;
            sum += pathSum;
            return;
        }
        findPath(root.left, currSum * 10 + root.val);
        findPath(root.right, currSum * 10 + root.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);
        System.out.println("Total Sum of Path Numbers: " + SumOfPathNumbers.findSumOfPathNumbers(root));
    }
}
