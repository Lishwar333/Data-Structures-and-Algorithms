package Algorithms_week_1.unionFind;

public class WeightedQuickUnionWithPathCompression {
    private int[] parent;
    private int[] size; // size[i] is the number of objects in the tree rooted at i

    public WeightedQuickUnionWithPathCompression(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    private int find(int p) {
        int root = p;
        while (parent[root] != root) {
            parent[root] = parent[parent[root]]; // Path compression
            root = parent[root];
        }
        return root;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP != rootQ) {
            // Attach the smaller tree to the root of the larger tree
            if (size[rootP] < size[rootQ]) {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            } else {
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            }
        }
    }

    public static void main(String[] args) {
        WeightedQuickUnionWithPathCompression uf = new WeightedQuickUnionWithPathCompression(10);
        uf.union(0, 1);
        uf.union(1, 2);
        uf.union(2, 3);

        System.out.println(uf.connected(0, 3)); // Should print true
        System.out.println(uf.connected(4, 5)); // Should print false
    }
}