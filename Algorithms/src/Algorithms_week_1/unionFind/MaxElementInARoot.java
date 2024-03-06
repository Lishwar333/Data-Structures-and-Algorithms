package Algorithms_week_1.unionFind;

//Union-find with specific canonical element. Add a method find() to the union-find data type so 
//that find(i) returns the largest element in the connected component containing i. 
//The operations, union(), connected(), and find() should all take logarithmic time or better.

public class MaxElementInARoot {
    private int[] parent;
    private int[] size;
    private int[] max;

    public MaxElementInARoot(int n) {
        parent = new int[n];
        size = new int[n];
        max = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
            max[i] = i;
        }
    }

    public int find(int i) {
        validateIndex(i);
        int root = findRoot(i);
        return max[root];
    }

    public boolean connected(int p, int q) {
        validateIndex(p);
        validateIndex(q);
        return findRoot(p)==findRoot(q);
    }

    public void union(int p, int q) {
        validateIndex(p);
        validateIndex(q);
        
       int rootP = findRoot(p);
       int rootQ = findRoot(q);
       
       if(rootP == rootQ) {
    	   return;
       }
       
       if(size[rootP] > size[rootQ]) {
    	   
    	   parent[rootQ] = rootP;
    	   size[rootP] = +size[rootQ];
    	   max[rootP] = Math.max(max[rootP], max[rootQ]);
       }
      // if(size[rootP] < size[rootQ]) { // can't use this as it checks this condition, immediately making a change previous condition 
       else {
    	   parent[rootP] = rootQ;
    	   size[rootQ] = +size[rootP];
    	   max[rootQ] = Math.max(max[rootP], max[rootQ]);
       }
       

       
    }

    private int findRoot(int i) {
        while (i != parent[i]) {
            parent[i] = parent[parent[i]]; // Path Compression
            i = parent[i];
        }
        return i;
    }

    private void validateIndex(int i) {
        int n = parent.length;
        if (i < 0 || i >= n) {
            throw new IllegalArgumentException("Index " + i + " is not between 0 and " + (n - 1));
        }
    }

    public static void main(String[] args) {
    	MaxElementInARoot uf = new MaxElementInARoot(10);

        uf.union(1, 2);
        uf.union(2, 6);
        uf.union(6, 9);

        System.out.println(uf.find(1)); // Output: 9
        System.out.println(uf.find(2)); // Output: 9
        System.out.println(uf.find(6)); // Output: 9
        System.out.println(uf.find(9)); // Output: 9
    }
}
