package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConstructBinaryTreePreorderInorder {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    private int preorderIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, TreeNode> valToTree = new HashMap();
        // assumption - there are no 2 nodes with same values
        for (int i : inorder) {
            valToTree.put(i, new TreeNode(i));
        }
        HashMap<Integer, Integer> valToInorderPos = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            valToInorderPos.put(inorder[i], i);
        }
        ArrayList<Integer> container = new ArrayList<>();
        TreeNode root = build(inorder, preorder, valToTree, valToInorderPos,
                0, preorder.length - 1);
        return root;
    }

    private TreeNode build(int[] inorder, int[] preorder,
                           Map<Integer, TreeNode> valToTree,
                           Map<Integer, Integer> valToInorderPos,
                           int start, int end) {
        if (start > end) {
            return null;
        }

        // get the next node (number) to process
        int nodeNumber = preorder[preorderIndex++];
        // get the node from map
        TreeNode treeNode = valToTree.get(nodeNumber);
        if (start == end) { // we reached a node which will not have any more children
            return treeNode; // return this node itself
        }
        // get inorder index of the node
        int inorderIndex = valToInorderPos.get(treeNode.val);

        TreeNode leftNode = build(inorder, preorder, valToTree, valToInorderPos,
                start, inorderIndex - 1);
        TreeNode rightNode = build(inorder, preorder, valToTree, valToInorderPos,
                inorderIndex + 1, end);
        treeNode.left = leftNode;
        treeNode.right = rightNode;

        return treeNode;
    }
}
