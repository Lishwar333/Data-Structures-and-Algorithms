package Algorithms_week_2.elementary_sorts;

public class Insertion_Sort implements Comparable {
	
	public void sort(Comparable[] arr) {
		
		Comparable[] arr2 = arr;
		int i;
		
		int N = arr2.length;
		for(i=0; i<N; i++) {
			
			for(int j=i; j>0; j--) {
				if(less(arr2[j], arr2[j-1])) {
					exch(arr2, j, j-1);
				}
				else {
					break;
				}
			}
			
			if(i==14) {
				for(int j=0; j<N; j++) {
					System.out.println(arr2[j]);
				}
		}
		
	}}
	
	public boolean less(Comparable x, Comparable y) {
		
		if(y.compareTo(x)>0) {
			return true;
		}
		
		return false;
		
	}
	
	public void exch(Comparable[] arr, int i, int j) {
		
		Comparable swap = arr[i];
		arr[i] = arr[j];
		arr[j] = swap;
		
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public static void main(String[] args) {
		
		Integer[] arr = {10,23,54,6,7,45,75,78,94,93,56,2,45,67,8};
		Insertion_Sort sort = new Insertion_Sort();
		sort.sort(arr);
		
		}

}