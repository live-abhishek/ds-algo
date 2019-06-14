package codingInterview.bfs;

import java.util.*;

public class LevelOrderTraversal {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> levelList = new ArrayList<>();
            for(int i = 0; i < levelSize; i++){
                TreeNode currNode = queue.poll();
                levelList.add(currNode.val);
                if(currNode.left != null){
                    queue.offer(currNode.left);
                }
                if(currNode.right != null){
                    queue.offer(currNode.right);
                }
            }
            result.add(levelList);
        }
        return result;
    }


    public static List<List<Integer>> traverseDoubleQueue(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Queue<TreeNode> currentQueue = new ArrayDeque<>();
        Queue<TreeNode> nextQueue = new ArrayDeque<>();
        currentQueue.add(root);
        result.add(Arrays.asList(root.val));
        List<Integer> levelNode = new ArrayList<>();
        while(!currentQueue.isEmpty()){
            TreeNode currNode = currentQueue.poll();
            if(currNode.left != null){
                levelNode.add(currNode.left.val);
                nextQueue.add(currNode.left);
            }
            if (currNode.right != null) {
                levelNode.add(currNode.right.val);
                nextQueue.add(currNode.right);
            }
            if(currentQueue.isEmpty() && !levelNode.isEmpty()){
                currentQueue = nextQueue;
                nextQueue = new ArrayDeque<>();
                result.add(levelNode);
                levelNode = new ArrayList<>();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<List<Integer>> result = LevelOrderTraversal.traverse(root);
        System.out.println("Level order traversal: " + result);
    }
}