package DSA;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class BFSExample {

    public List<Integer> bfs(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>(); // Queue for BFS
        queue.offer(root); // Add root to queue

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll(); // Remove from front
            result.add(current.val);         // Visit node

            if (current.left != null) {
                queue.offer(current.left);   // Add left child
            }

            if (current.right != null) {
                queue.offer(current.right);  // Add right child
            }
        }

        return result;
    }

    // For testing
    public static void main(String[] args) {
        BFSExample bfs = new BFSExample();

        // Building tree manually:
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<Integer> result = bfs.bfs(root);
        System.out.println("BFS traversal: " + result);
    }
}
