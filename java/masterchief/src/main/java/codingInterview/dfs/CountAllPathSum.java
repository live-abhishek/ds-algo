package codingInterview.dfs;

import java.util.ArrayList;
import java.util.List;

public class CountAllPathSum {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static int count = 0;

    public static int countPaths(TreeNode root, int S) {
        traverse(root, S, new ArrayList<>());
        return count;
    }

    private static void traverse(TreeNode root, int S, List<Integer> pathPrefixSum) {
        if (root == null) {
            return;
        }
        if (pathPrefixSum.size() > 0) {
            pathPrefixSum.add(root.val + pathPrefixSum.get(pathPrefixSum.size() -1));
        } else {
            pathPrefixSum.add(root.val);
        }
        // do some test & take action based on that test
        if (testPath(pathPrefixSum, S)) {
            count++;
        }
        // then traverse
        traverse(root.left, S, pathPrefixSum);
        traverse(root.right, S, pathPrefixSum);
        pathPrefixSum.remove(pathPrefixSum.size() - 1);
    }

    private static boolean testPath(List<Integer> list, int S){
        int last = list.get(list.size() - 1);
        if (last == S) {
            return true;
        }
        for (int i = 1; i < list.size(); i++) {
            if (last - list.get(i - 1) == S) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree has path: " + CountAllPathSum.countPaths(root, 11));
    }
}
