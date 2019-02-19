package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestor {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> leftAncestor = getAncestorList(root, p);
        List<TreeNode> rightAncestor = getAncestorList(root, q);
        TreeNode lca = null;
        int i = 0;
        while(i < leftAncestor.size() && i < rightAncestor.size()
                && leftAncestor.get(i) == rightAncestor.get(i)){
            lca = leftAncestor.get(i++);
        }
        return lca;
    }

    private List<TreeNode> getAncestorList(TreeNode root, TreeNode source){
        ArrayList<TreeNode> treeNodes = new ArrayList<>();
        getAnscetorList(root, source, treeNodes);
        return treeNodes;
    }

    private boolean getAnscetorList(TreeNode root, TreeNode source, List<TreeNode> ancestorList) {
        if (root == null) {
            return false;
        }
        if (root.val == source.val) {
            ancestorList.add(root);
            return true;
        }
        ancestorList.add(root);
        if(getAnscetorList(root.left, source, ancestorList)
                || getAnscetorList(root.right, source, ancestorList)){
            return true;
        } else {
            ancestorList.remove(ancestorList.size() - 1);
            return false;
        }
    }
}
