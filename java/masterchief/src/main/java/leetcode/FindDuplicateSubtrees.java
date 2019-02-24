package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateSubtrees {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, List<TreeNode>> map = new HashMap<>();
        postOrder(root, map);
        List<TreeNode> duplicateNodes = new ArrayList<>();
        for (Map.Entry<String, List<TreeNode>> entries : map.entrySet()) {
            if (entries.getValue().size() > 1) {
                duplicateNodes.add(entries.getValue().get(0));
            }
        }
        return duplicateNodes;
    }

    private String postOrder(TreeNode node, Map<String, List<TreeNode>> map){
        if (node == null) {
            return "#";
        }
        String serializedString = node.val + "," + postOrder(node.left, map) + "," + postOrder(node.right, map);
        if (!map.containsKey(serializedString)) {
            map.put(serializedString, new ArrayList<>());
        }
        map.get(serializedString).add(node);
        return serializedString;
    }

}
