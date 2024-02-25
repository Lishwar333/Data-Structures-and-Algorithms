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
        int rootP = findRoot(p);
        int rootQ = findRoot(q);

        if (rootP != rootQ) {
            parent[rootP] = rootQ;  // Make rootQ the parent of rootP.
        }
    }

    // Find operation - find the root of the element's tree (set).
    public int findRoot(int p) {
        while (p != parent[p]) {
            p = parent[p];  // Traverse up the tree to find the root.
        }
        return p;
    }

    public static void main(String[] args) {
        int n = 10;
        QuickUnion quickUnion = new QuickUnion(n);

        // Creating a worst-case scenario where the tree becomes a linked list.
        for (int i = 0; i < n - 1; i++) {
            quickUnion.union(i, i + 1);
        }

        // Perform a find operation on the last element.
        int root = quickUnion.findRoot(n - 1);

        // The tree is a linked list, and the height is equal to the number of elements.
        // Both union and find operations have O(N) time complexity in this worst-case scenario.
        
        System.out.print(root);
    }
}