package Algorithms_week_1.unionFind;

//I think it is correct

//Successor with delete. Given a set of N integers S={0,1,…,N−1} and a 
//sequence of requests of the following form:

//Remove x from S Find the successor of x: the smallest y in S such that 
//y≥x. design a data type so that all operations (except construction) 
//should take logarithmic time or better.

public class SuccessorWithDelete {

    private int id[];
    private int sz[];
    private int actualList[]; //Actually id[] itself is enough for this problem
    private int N;

    public SuccessorWithDelete(int N){
        this.N = N;
        id = new int[N];
        sz = new int[N];
        actualList = new int[N];
        for(int i=0; i<N; i++){
            id[i] = i; //parent
            sz[i] = 1;
            actualList[i] = i;
        }
    }

    // returns the root of the component the integer is in
    private int root(int i){
        while(id[i]!=i){

            i = id[i];
        }
        return i;
    }

    // weighted quick union
    public void union(Integer p, Integer q) {

        int pRoot = root(p);
        int qRoot = root(q);
        
        // No need of if else and all as rootP has to only be merged with rootQ
            id[pRoot] =  qRoot;
            sz[qRoot] = sz[qRoot] + sz[pRoot];
            actualList[pRoot] = actualList[qRoot];  // this is the crucial step

    }

    public void remove(int x){
        union(x, x+1);

    }

    public int successor(int x){
        return actualList[(root(x+1))]; //return actualList[root(x + 1)];
        //Actually id itslef id enough. id[(root(x+1))] will do the same!
    }
    
    public static void main(String[] args) {
        int N = 10; // Change N to the desired size
        SuccessorWithDelete swd = new SuccessorWithDelete(N);

        System.out.println("Initial actualList:");

        // Test remove and successor operations
        swd.remove(3);
        System.out.println("After removing 3:");
        System.out.println("Successor of 2: " + swd.successor(2));

        swd.remove(5);
        System.out.println("After removing 5:");
        System.out.println("Successor of 4: " + swd.successor(4));

        swd.remove(7);
        System.out.println("After removing 7:");
        System.out.println("Successor of 6: " + swd.successor(6));
        
        swd.remove(4);
        System.out.println("After removing 4:");
        System.out.println("Successor of 2: " + swd.successor(2)); //is this correct? // am I understanding the question correctly?
        
        swd.remove(7);
        System.out.println("After removing 7:");
        System.out.println("Successor of 6: " + swd.successor(6));
    }
}