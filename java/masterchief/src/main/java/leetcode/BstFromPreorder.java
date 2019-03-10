package leetcode;

public class BstFromPreorder {
    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        return constructTree(preorder, 0, preorder.length - 1);
    }

    private TreeNode constructTree(int[] preorder, int start, int end){
        if (start > end) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[start]);
        int i;
        for (i = start; i <= end; i++) {
            if (preorder[i] > root.val) {
                break;
            }
        }
        root.left = constructTree(preorder, start + 1, i - 1);
        root.right = constructTree(preorder, i, end);
        return root;
    }


    public static void main(String[] args) {
        BstFromPreorder b = new BstFromPreorder();
        int[] arr = {4,2};
        TreeNode treeNode = b.bstFromPreorder(arr);
        System.out.println(treeNode);
    }
}
