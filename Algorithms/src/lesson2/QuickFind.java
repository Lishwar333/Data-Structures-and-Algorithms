package lesson2;
public class QuickFind {
    private int[] id;

    // Constructor to initialize the data structure
    public QuickFind(int size) {
        id = new int[size];
        for (int i = 0; i < size; i++) {
            id[i] = i; // Each element initially belongs to its own set
        }
    }

    // Check if two elements are in the same set
    public boolean isConnected(int p, int q) {
        return id[p] == id[q];
    }

    // Merge two sets by changing the set identifier of all elements in one set
    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];

        // Change the set identifier of all elements in set 'p' to the set identifier of 'q'
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) {
                id[i] = qid;
            }
        }
    }

    public static void main(String[] args) {
        // Example usage
        int size = 10;
        QuickFind uf = new QuickFind(size);

        uf.union(0, 1);
        uf.union(2, 3);
        uf.union(4, 5);
        uf.union(6, 7);
        uf.union(8, 9);

        System.out.println("Is 0 connected to 7? " + uf.isConnected(0, 7)); // Should be false
        System.out.println("Is 4 connected to 5? " + uf.isConnected(4, 5)); // Should be true

        uf.union(1, 9); // Merge sets containing elements 0 and 9

        System.out.println("Is 0 connected to 8 after union? " + uf.isConnected(0, 8)); // Should be true
    }
}