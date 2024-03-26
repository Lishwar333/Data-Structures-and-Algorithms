package Algorithms_week_2.elementary_sorts;

public class Selection_Sort implements Comparable {
	
	public void sort(Comparable[] arr) {
		
		Comparable[] arr2 = arr;
		int i;
		
		int N = arr2.length;
		for(i=0; i<N; i++) { 
			int min = i;
			
			for(int j=i+1; j<N; j++) {
				
				if(less(arr2[j], arr2[min])) {
					min = j;
				}
			}
			
			exch(arr2, i, min);
			
			if(i==14) {
				for(int j=0; j<N; j++) {
					System.out.println(arr2[j]);
				}
				
			}
			
		}
		
	}
	
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
		Selection_Sort sort = new Selection_Sort();
		sort.sort(arr);
		
		}

}