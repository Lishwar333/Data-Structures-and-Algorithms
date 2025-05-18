package Algorithms_week4;

import java.util.Scanner;

//Priority Queue
public class UnorderedMaxPQ<Key extends Comparable<Key>> {
	
	private Key[] pq;
	private int N=0;
	
	@SuppressWarnings("unchecked")
	public UnorderedMaxPQ(int capacity) {
		pq = (Key[]) new Comparable[capacity];
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public void insert(Key x) {
		pq[N++] = x;
	}
	
	public Key delMax() {
		int max = 0;
		for (int i = 1; i < N; i++) {
			if (less(pq[max], pq[i])) max = i;
		}
		exch(max, N-1);
		return pq[--N];
	}
	
	private boolean less(Key x, Key y) {
		return x.compareTo(y) < 0;
	}
	
	private void exch(int x, int y) {
		Key swap = pq[x];
		pq[x] = pq[y];
		pq[y] = swap;
	}
	
	public int size() {
		return N;
	}
	
	public void show() {
		for(int i=0; i<3;i++) {
			System.out.print(pq[i]+" ");
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		UnorderedMaxPQ<Integer> pq = new UnorderedMaxPQ<>(10);
		Scanner scan = new Scanner(System.in);
		
		while(scan.hasNext()){
			
			int item = scan.nextInt();
            if (item == -1) {
                break;
            }
            pq.insert(item);
            
            if (pq.size() > 3) {
                pq.delMax();
            }
            pq.show();
		}
		scan.close();
		System.out.println("Max element: " + pq.delMax());
	}
}
