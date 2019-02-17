package leetcode;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class CousinsBinaryTree {
    public boolean isCousins(TreeNode root, int x, int y) {
        int[] pX = getParentInfo(null, root, x, 0);
        int[] pY = getParentInfo(null, root, y, 0);
        if (pX[0] == 0 || pY[0] == 0) { // one of the parent is null (root's parent)
            return false;
        }
        // if depth is same but parent are not same
        if (pX[1] == pY[1] && pX[0] != pY[0]) {
            return true;
        }
        return false;
    }

    private int[] getParentInfo(TreeNode parent, TreeNode current, int x, int d){
        if (current == null) {
            return new int[] {0, 0};
        }
        if(current.val == x && parent != null){
            return new int[] {parent.val, d};
        } else {
            int[] parentLeft = getParentInfo(current, current.left, x, d+1);
            int[] parentRight = getParentInfo(current, current.right, x, d+1);
            if (parentLeft[0] != 0) {
                return parentLeft;
            } else if (parentRight[0] != 0) {
                return parentRight;
            } else {
                return new int[] {0, 0};
            }
        }
    }
}
