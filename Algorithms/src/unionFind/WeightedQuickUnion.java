package unionFind;

public class WeightedQuickUnion {

    private int[] parent;
    private int[] size;  // Array to keep track of the size of each tree.

    public WeightedQuickUnion(int n) {
        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;  // Initialize each tree size to 1.
        }
    }

    // Union operation with weight - connect two elements, attaching the smaller tree to the larger tree.
    public void union(int p, int q) {
        int rootP = findRoot(p);
        int rootQ = findRoot(q);

        if (rootP != rootQ) {
            if (size[rootP] < size[rootQ]) {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            } else {
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            }
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
        WeightedQuickUnion weightedQuickUnion = new WeightedQuickUnion(n);

        // Perform union operations to create a balanced tree.
        weightedQuickUnion.union(0, 1);
        weightedQuickUnion.union(2, 3);
        weightedQuickUnion.union(4, 5);
        weightedQuickUnion.union(6, 7);
        weightedQuickUnion.union(0, 2);
        weightedQuickUnion.union(4, 6);
        weightedQuickUnion.union(0, 4);

        // Perform find operations.
        int rootOf3 = weightedQuickUnion.findRoot(3);
        int rootOf7 = weightedQuickUnion.findRoot(7);

        // The tree remains balanced, and both union and find operations have O(log N) time complexity.
        
        System.out.print(rootOf3+""+rootOf7);
    }
}