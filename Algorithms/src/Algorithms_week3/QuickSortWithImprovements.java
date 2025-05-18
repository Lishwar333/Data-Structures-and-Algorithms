package Algorithms_week3;

// Java program for implementation of QuickSort
class QuickSortWithImprovements {
    /* This function takes last element as pivot,
    places the pivot element at its correct
    position in sorted array, and places all
    smaller (smaller than pivot) to left of
    pivot and all greater elements to right
    of pivot */
    int partition(int arr[], int low, int high) {
        // Median of three for pivot selection
        int pivotIndex = medianOfThree(arr, low, high);
        int pivot = arr[pivotIndex];
        swap(arr, pivotIndex, high);

        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    // Utility function to swap two elements in an array
    void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Median of three helper function
    int medianOfThree(int arr[], int low, int high) {
        int mid = low + (high - low) / 2;
        if (arr[low] > arr[mid]) {
            if (arr[mid] > arr[high])
                return mid;
            else if (arr[low] > arr[high])
                return high;
            else
                return low;
        } else {
            if (arr[low] < arr[high])
                return high;
            else if (arr[mid] < arr[high])
                return mid;
            else
                return low;
        }
    }

    /* The main function that implements QuickSort()
    arr[] --> Array to be sorted,
    low --> Starting index,
    high --> Ending index */
    void sort(int arr[], int low, int high) {
        if (low < high) {
            // If the size of the subarray is less than or equal to 10, switch to insertion sort
            if (high - low + 1 <= 10) {
                insertionSort(arr, low, high);
                return;
            }

            int pi = partition(arr, low, high);
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    // Insertion sort for small arrays
    void insertionSort(int arr[], int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= low && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver program
    public static void main(String args[]) {
        int arr[] = {10, 7, 8, 9, 1, 5};
        int n = arr.length;

        QuickSortWithImprovements ob = new QuickSortWithImprovements();
        ob.sort(arr, 0, n - 1);

        System.out.println("sorted array");
        printArray(arr);
    }
}
