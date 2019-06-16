package codingInterview.dfs;

public class PathWithGivenSequence {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static boolean findPath(TreeNode root, int[] sequence) {
        return traverse(root, sequence, 0);
    }

    private static boolean traverse(TreeNode root, int[] sequence, int id) {
        if(root == null || id >= sequence.length || root.val != sequence[id]) {
            return false;
        }
        if (id == sequence.length - 1 && root.left == null && root.right == null) {
            return true;
        }
        return traverse(root.left, sequence, id + 1) || traverse(root.right, sequence, id + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);

        System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 0, 7 }));
        System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 1, 6 }));
    }
}
