package Algorithms_week3;

public class MergeSort {
	
	private static boolean less(Comparable x, Comparable y) {
		
		if(y.compareTo(x)>0) {
			return true;
		}else {
			return false;
		}
		
	}

	private static void merge(Comparable[] a, Comparable[] awl, int lo, int mid, int hi) {
		
		for(int k=0; k<=hi; k++) {
			awl[k] = a[k];
		}
		
		int i=lo, j=mid+1;
		
		for(int k=lo; k<=hi; k++) {
			
			if(i>mid) { a[k] = awl[j++];}
			else if (j>hi) { a[k] = awl[i++];}
			else if (less(awl[j], awl[i])) { a[k] = awl[j++];}
			else {a[k] = awl[i++];}
		
	}
	}
	
	
	private static void sort(Comparable[] a, Comparable[] awl, int lo, int hi) {
		
		if(hi<=lo) {
			return;
		}
		
		int mid = (lo + hi)/2;
		
		sort(a, awl, lo, mid);
		sort(a, awl, mid + 1, hi);
		merge(a, awl, lo, mid, hi);
		
		
	}
	
	public static void  sort(Comparable[] a) {
		
		Comparable[] awl = new Comparable[a.length];
		sort(a, awl, 0, a.length-1);
	}
	
	public static void main(String[] args) {
		
		Integer[] arr = {10,23,54,6,7,45,75,78,94,93,56,2,45,67,8, 95};
		sort(arr);
		
		for(int i=0; i<arr.length; i++) {
			
			System.out.println(arr[i]);
			
		}
		
	}


}
