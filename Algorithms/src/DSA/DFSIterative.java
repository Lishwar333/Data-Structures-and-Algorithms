package DSA;

import java.util.*;

public class DFSIterative {
	
	
    public List<Integer> dfsInOrder(TreeNode root) {
    	
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            // Reach the leftmost node
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // Backtrack
            current = stack.pop();
            result.add(current.val);  // Visit the node

            // Visit the right subtree
            current = current.right;
        }

        return result;
    }

    public static void main(String[] args) {
        // Build sample tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        DFSIterative dfs = new DFSIterative();
        List<Integer> result = dfs.dfsInOrder(root);
        System.out.println("DFS In-Order (Iterative): " + result);
    }
}