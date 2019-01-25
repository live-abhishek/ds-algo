package leetcode;

public class VerifyPreorderSerializationBinaryTree {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        if(preorder.isEmpty()) return false;
        int remainingNodes = 1;
        for (String node : nodes) {
            remainingNodes--;
            if(remainingNodes < 0) break;
            if(!node.equals("#")) remainingNodes += 2;
        }
        return remainingNodes == 0;
    }
}
