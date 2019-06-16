package codingInterview.dfs;

import java.util.ArrayList;
import java.util.List;

public class FindAllTreePaths {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static List<List<Integer>> findPaths(TreeNode root, int sum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        findPath(root, allPaths, new ArrayList<>(), sum);
        return allPaths;
    }

    private static void findPath(TreeNode root, List<List<Integer>> result, List<Integer> currPath, int sum) {
        if (root == null) {
            return;
        }
        if (sum == root.val && root.left == null && root.right == null) {
            currPath.add(root.val);
            result.add(new ArrayList<>(currPath));
            currPath.remove(currPath.size() - 1);
            return;
        }
        currPath.add(root.val);
        findPath(root.left, result, currPath, sum - root.val);
        findPath(root.right, result, currPath, sum - root.val);
        currPath.remove(currPath.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        int sum = 23;
        List<List<Integer>> result = FindAllTreePaths.findPaths(root, sum);
        System.out.println("Tree paths with sum " + sum + ": " + result);
    }
}
