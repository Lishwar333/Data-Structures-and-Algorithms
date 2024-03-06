package complexities;

/**
 * Coursera - Algorithms Part I
 * Week 1 - Interview Questions - Analysis of Algorithms
 *
 * Question 1: 3-SUM in quadratic time
 *
 * Design an algorithm for the 3-SUM problem that takes time proportional to N2
 * in the worst case. You may assume that you can sort the N integers in time
 * proportional to N2 or better.
 */

import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;

class ThreeSum {

  public static void main(String[] args) {

    // initialize array
    ArrayList<Integer> data = new ArrayList<Integer>();
    Scanner scan = new Scanner(System.in);
    
    int count=0;
    while (scan.hasNextInt()) {
      data.add(scan.nextInt());
    }

    // sort array
    Collections.sort(data);

    // compute all 3-sum combinations
    // This method primarly works because of the sort we did in the previous line!, so initially the sum is gonna be 
    // -ve and as the j moves up, sum gets positive
    for (int i = 0; i < data.size()-2; ++i) {
      int j = i+1;
      int k = data.size()-1;

      while (j < k) {
        int sum = data.get(i)+data.get(j)+data.get(k);
        if (sum == 50) {
          System.out.println(i+":"+data.get(i)+", "+j+":"+data.get(j)+", "+k+":"+data.get(k));
        }
        if (sum >= 50) {
          --k;
        } else {
          ++j;
        }
        count++;
      }
    }
    
    System.out.println(count);

  }

}