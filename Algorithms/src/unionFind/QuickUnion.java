package unionFind;
public class QuickUnion {

    private int[] parent;

    public QuickUnion(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;  // Each element is initially its own root.
        }
    }

    // Union operation - connect two elements by setting one root as the parent of the other.
    public void union(int p, int q) {
        
    	int root1 = findRoot(p);
    	int root2 = findRoot(q);
    	
    	if(root1 != root2) { 
    		parent[p]=root2; // Make rootQ the parent of rootP.
    	}
    	else {
    		System.out.println("They have same roots/ already connected");
    	}
    }

    // Find operation - find the root of the element's tree (set).
    public int findRoot(int p) {
        while (p != parent[p]) {
        	p = parent[p]; // Traverse up the tree to find the root.
        }
     return p;   
    }

    public static void main(String[] args) {
        int n = 10;
        QuickUnion quickUnion = new QuickUnion(n);
        
        
        quickUnion.union(0, 6);
        quickUnion.union(1, 6);
        quickUnion.union(4, 5);
        quickUnion.union(0, 6);
        
        System.out.print(quickUnion.findRoot(1));
    }
}