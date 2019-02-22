package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class InorderTraversalManualStack {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<>();
        stk.push(root);
        while (!stk.isEmpty()) {
            if (stk.peek() != null) {
                stk.push(stk.peek().left);
            } else {
                stk.pop(); // remove the null
                if(!stk.isEmpty()) { // if still there is a node
                    TreeNode node = stk.pop(); // pop the current node
                    inorder.add(node.val); // insert in the inorder list
                    stk.push(node.right); // time to process right node
                }
            }
        }
        return inorder;
    }

}
