package Algorithms_week4;

import java.util.Scanner;

public class HeapSort<T extends Comparable<? super T>> {

    private int N = 0; // size
    private T[] hs;

    @SuppressWarnings("unchecked")
    public HeapSort(int capacity) {
        hs = (T[]) new Comparable[capacity + 1]; // One extra space for 1-based indexing
    }

    public void sort() {
        // Build the heap
        for (int k = N / 2; k >= 1; k--) {
            sink(k, N);
        }

        int originalN = N; // Store original size
        
        while (N > 1) {
            exch(1, N);
            sink(1, --N);
        }
        N = originalN; // Reset N to original size after sorting
    }

    public void insert(T x) {
        hs[++N] = x; // Insert at position N and then increment N
    }

    private void sink(int k, int N) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(j, j + 1)) {
                j++;
            }
            if (!less(k, j)) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }

    private boolean less(int i, int j) {
        return hs[i].compareTo(hs[j]) < 0; // Compare actual elements
    }

    private void exch(int i, int j) {
        T t = hs[i];
        hs[i] = hs[j];
        hs[j] = t;
    }

    public void show() {
        for (int i = 1; i <= N; i++) {
            System.out.print(hs[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        HeapSort<Integer> hs = new HeapSort<>(10);
        Scanner scan = new Scanner(System.in);

        while (scan.hasNext()) {
            int item = scan.nextInt();
            if (item == -1) {
                break;
            }
            hs.insert(item);
        }
        scan.close();
        hs.sort();
        hs.show();
    }
}
