package leetcode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeInorderPostorder {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    private int postIndex = 0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, TreeNode> valToNode = new HashMap<>();
        for (int i : postorder) {
            valToNode.put(i, new TreeNode(i));
        }
        Map<Integer, Integer> valToInorderPos = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            valToInorderPos.put(inorder[i], i);
        }
        postIndex = postorder.length - 1;
        TreeNode root = build(inorder, postorder, valToNode, valToInorderPos,
                0, postorder.length - 1);
        return root;
    }

    private TreeNode build(int[] inorder, int[] postorder,
                           Map<Integer, TreeNode> valToNode,
                           Map<Integer, Integer> valToInorderPos,
                           int start, int end) {
        if (start > end) {
            return null; // no node
        }

        int nodeNumber = postorder[postIndex--];
        TreeNode treeNode = valToNode.get(nodeNumber);
        if (start == end) {
            return treeNode;
        }

        Integer inorderIndex = valToInorderPos.get(treeNode.val);
        TreeNode rightNode = build(inorder, postorder, valToNode, valToInorderPos,
                inorderIndex + 1, end);
        TreeNode leftNode = build(inorder, postorder, valToNode, valToInorderPos,
                start, inorderIndex - 1);
        treeNode.left = leftNode;
        treeNode.right = rightNode;

        return treeNode;
    }

}
