package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class SerailizeDeserailizeBinaryTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        List<Integer> serializedNodes = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode currNode = queue.removeFirst();
            if (currNode != null) {
                serializedNodes.add(currNode.val);
                queue.add(currNode.left);
                queue.add(currNode.right);
            } else {
                serializedNodes.add(null);
            }
        }
        ListIterator<Integer> itr = serializedNodes.listIterator(serializedNodes.size());
        // remove null(s) from the end
        while (itr.hasPrevious()) {
            Integer previous = itr.previous();
            if (previous == null) {
                itr.remove();
            } else {
                break;
            }
        }
        String serialized = serializedNodes.stream().map(i -> i == null ? "null" : Integer.toString(i))
                .collect(Collectors.joining(","));
        System.out.println(serialized);
        return serialized;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        String[] nodeVal = data.split(",");
        TreeNode[] nodes = new TreeNode[nodeVal.length];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = nodeVal[i].equals("null") ? null
                    : new TreeNode(Integer.parseInt(nodeVal[i].trim()));
        }
        System.out.println("node creation done");
        TreeNode root = nodes[0];
        int currNodePos = 0;
        boolean isLeftTurn = true;
        for (int i = 1; i < nodes.length; i++) {
            TreeNode currNode = nodes[currNodePos];
            if (currNode == null) {
                currNodePos++;
                isLeftTurn = true;
                continue;
            }
            if (isLeftTurn) {
                currNode.left = nodes[i];
            } else {
                currNode.right = nodes[i];
                currNodePos++;
            }
            isLeftTurn = !isLeftTurn;
        }
        return root;
    }

}
