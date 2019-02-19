package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class LevelOrderTraversal {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    static class LevelNode {
        int level; TreeNode node;
        LevelNode(TreeNode node, int level){
            this.node = node;
            this.level = level;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelOrder = new ArrayList<>();
        LinkedList<LevelNode> queue = new LinkedList<>();
        queue.add(new LevelNode(root, 0));
        while (!queue.isEmpty()) {
            LevelNode levelNode = queue.removeFirst();
            if (levelNode.node == null) {
                continue;
            }
            while (levelNode.level >= levelOrder.size()) {
                levelOrder.add(new ArrayList<>());
            }
            levelOrder.get(levelNode.level).add(levelNode.node.val);
            queue.add(new LevelNode(levelNode.node.left, levelNode.level + 1));
            queue.add(new LevelNode(levelNode.node.right, levelNode.level + 1));
        }
        return levelOrder;
    }
}
