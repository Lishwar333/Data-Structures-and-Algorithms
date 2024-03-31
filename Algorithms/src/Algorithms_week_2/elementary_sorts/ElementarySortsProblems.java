package Algorithms_week_2.elementary_sorts;

import edu.princeton.cs.algs4.Shell;

public class ElementarySortsProblems {
    /*
    Question 1
    Intersection of two sets.
    Given two arrays a[] and b[], each containing N distinct 2D points in the plane,
    design a subquadratic algorithm to count the number of points that are contained both in array a[] and array b[].
     */

    class Point implements Comparable<Point>{
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point that) {
            if (that.x > this.x) return -1;
            if (that.x < this.x) return 1;
            if (that.y > this.y) return -1;
            if (that.y < this.y) return 1;
            return 0;
        }

        public int countIntersection(Point[] a, Point[] b) {
            Shell.sort(a);
            Shell.sort(b);

            int i = 0;
            int j = 0;
            int count = 0;

            while (i < a.length && j < b.length) {
                if (a[i].compareTo(b[j]) == 0) {
                    count++;
                    i++;
                    j++;
                }
                else if (a[i].compareTo(b[j]) < 0) i++;
                else j++;
            }
            return count;
        }
    }

    /*
    Question 2
    Permutation.
    Given two integer arrays of size N, design a subquadratic algorithm to determine whether one is a permutation of the other.
    That is, do they contain exactly the same entries but, possibly, in a different order.
     */

    public boolean isPerm(Integer[] a, Integer[] b) {
        if (a.length != b.length) return false;
        Shell.sort(a);
        Shell.sort(b);

        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

    /*
    Question 3
    Dutch national flag. Given an array of N buckets, each containing a red, white, or blue pebble, sort them by color. The allowed operations are:
    swap(i,j): swap the pebble in bucket i with the pebble in bucket j.
    color(i): color of pebble in bucket i.
    The performance requirements are as follows:
    At most N calls to color().
    At most N calls to swap().
    Constant extra space.
     */

    class SortColors {

    	  void sortColors(int[] nums) {

    	    int start = 0;
    	    int mid = 0;
    	    int end = nums.length - 1;

    	    while (mid <= end) {

    	      switch (nums[mid]) {
    	        case 0:
    	          // Swap with start index
    	          swap(nums, start, mid);
    	          mid++;
    	          start++;
    	          break;

    	        case 1:
    	          mid++;
    	          break;

    	        case 2:
    	          // Swap with end index
    	          swap(nums, mid, end);
    	          end--;
    	          break;
    	      }
    	    }

    	  }

    	  private void swap(int[] arr, int pos1, int pos2) {
    	    int temp = arr[pos1];
    	    arr[pos1] = arr[pos2];
    	    arr[pos2] = temp;
    	  }

    	}


}