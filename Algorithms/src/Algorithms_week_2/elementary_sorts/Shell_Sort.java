package Algorithms_week_2.elementary_sorts;

public class Shell_Sort implements Comparable {
	
	public void sort(Comparable[] arr) {
		
		Comparable[] arr2 = arr;
		int i;
		int N = arr2.length;
		
		int h = 1;
		while(h<=N/3) {
			h = 3*h+1;
		}
		
		while(h>=1) {
			
			for(i=h; i<N; i++) {
				
				for(int j=i; j>=h && less(arr2[j], arr2[j-h]); j-=h) {
					
					exch(arr2, j, j-h);
				}
			
		}
			h = h/3;
			
		}
			
		for(int j=0; j<N; j++) {
					System.out.println(arr2[j]);
		
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
		
		Integer[] arr = {10,23,54,6,7,45,75,78,94,93,56,2,45,67,8,7,45,75,78,94,93,56,2,45,};
		Shell_Sort sort = new Shell_Sort();
		sort.sort(arr);
		
		}

}