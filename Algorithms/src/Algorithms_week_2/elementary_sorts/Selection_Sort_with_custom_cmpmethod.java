package Algorithms_week_2.elementary_sorts;

public class Selection_Sort_with_custom_cmpmethod implements Comparable<Integer> {
	
	public void sort(int[] arr) {
		
		int[] arr2 = arr;
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
	
	public boolean less(Integer x, Integer y) {
		
		if(compareTo(x, y)>0) {
			return true;
		}
		
		return false;
		
	}
	
	public void exch(int[] arr, int i, int j) {
		
		int swap = arr[i];
		arr[i] = arr[j];
		arr[j] = swap;
		
	}
	
	public int compareTo(Integer x, Integer y) {
		
		if(x<y) {
			return 1;
		}
		return -1;
	}
	

	@Override
	public int compareTo(Integer o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public static void main(String[] args) {
		
		int[] arr = {10,23,54,6,7,45,75,78,94,93,56,2,45,67,8};
		Selection_Sort_with_custom_cmpmethod sort = new Selection_Sort_with_custom_cmpmethod();
		sort.sort(arr);
		
		}

}