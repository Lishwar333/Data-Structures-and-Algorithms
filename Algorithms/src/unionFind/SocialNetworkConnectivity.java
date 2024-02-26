package unionFind;
import java.util.Arrays;

//Social network connectivity. Given a social network containing n 
//members and a log file containing m timestamps at which times pairs of members 
//formed friendships, design an algorithm to determine the earliest time at which
//all members are connected (i.e., every member is a friend of 
//a friend of a friend ... of a friend). Assume that the log file is sorted by 
//timestamp and that friendship is an equivalence relation. 
//The running time of your algorithm should be mlogn or better and use extra 
//space proportional to n.


class UnionFind {
    int[] parent;
    private int[] rank;

    public UnionFind(int size) {
        parent = new int[size];
        rank = new int[size];

        // Initialize each element as its own parent with rank 0
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    // Find the root of the set to which x belongs (with path compression)
    int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);  // Path compression
        }
        return parent[x];
    }

    // Union operation to merge two sets (with rank optimization)
    void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
                rank[rootY]++;
                
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
                rank[rootX]++;
            } else {
                parent[rootX] = rootY;
                rank[rootY]++;
            }
        }
        
        System.out.println("Union - x: " + x + ", y: " + y);
        System.out.println("RootX: " + rootX + ", RootY: " + rootY);
        System.out.println("Parent: " + Arrays.toString(parent));
        System.out.println("Rank: " + Arrays.toString(rank));
        
    }

    
    
}

public class SocialNetworkConnectivity {

    public static int earliestConnectionTime(int n, int[][] log) {
        UnionFind uf = new UnionFind(n);

        for (int[] entry : log) {
            int timestamp = entry[0];
            int member1 = entry[1];
            int member2 = entry[2];

            uf.union(member1, member2);
            
            System.out.println(Arrays.toString(uf.parent));
            System.out.println();
            // Check if all members are now connected // Wrong as there can be diff root for some, which 
            //has the element with has the parent root
//            if (Arrays.stream(uf.parent).distinct().count() == 1) {
//            	
//                return timestamp;
//            }
            //The perfect way, using the find function
            if (Arrays.stream(uf.parent).map(uf::find).distinct().count() == 1) {
                return timestamp;
            }
           
            //also fails if 1st union operation itself is union(0,4)
//            if (uf.find(0) == uf.find(n - 1)) {
//                return timestamp;
//            }
        }

        return -1; // Return -1 if the network is not fully connected
    }

    public static void main(String[] args) {
    	
        int n = 5;  // Number of members
        int[][] log = {
            {1, 0, 1},
            {2, 1, 2},
            {3, 3, 4},
            {4, 2, 3},
            {5, 0, 4},
            {6, 1, 4},
            {7, 1, 0}
            // Timestamp, Member1, Member2
        };

        int earliestTime = earliestConnectionTime(n, log);
        
        

        if (earliestTime != -1) {
            System.out.println("Earliest connection time: " + earliestTime);
        } else {
            System.out.println("Network is not fully connected.");
        }
    }
}
