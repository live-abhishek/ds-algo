package codingInterview.dfs;

public class TreeDiameter {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    static int naxSize = 0;

    public static int findDiameter(TreeNode root) {
        calcMaxSize(root);
        return naxSize;
    }

    private static int calcMaxSize(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftSize = calcMaxSize(root.left);
        int rightSize = calcMaxSize(root.right);
        naxSize = Integer.max(naxSize, leftSize + rightSize + 1);
        return Integer.max(leftSize, rightSize) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println("Tree Diameter: " + TreeDiameter.findDiameter(root));
        root.left.left = null;
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        root.right.left.right.left = new TreeNode(10);
        root.right.right.left.left = new TreeNode(11);
        System.out.println("Tree Diameter: " + TreeDiameter.findDiameter(root));
    }
}
