package DSA;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class dfsIOP {
	
	private List<Integer> dfsInOrder(TreeNode root) {
		
		List<Integer> result = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode current = root;
		
		while(current != null || !stack.isEmpty() ) {
			
			while(current != null) {
				
				stack.add(current);
				current = current.left;
			}
			
			current = stack.pop();
			result.add(current.val);
			
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

        dfsIOP dfs = new dfsIOP();
        List<Integer> result = dfs.dfsInOrder(root);
        System.out.println("DFS In-Order (Iterative) now: " + result);
    }

}


