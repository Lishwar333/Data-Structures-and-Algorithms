package Complexities;

public class BinarySearchProblem1 {
//	// Little confusing
//	public static int binarySearch(int[] nums, int target) {
//		
//		int l = nums.length;
//		int initial = 0;
//		int mid = (initial + (l - initial))/2;
//		
//		while(nums[mid] != target) {
//			
//			if(nums[mid]>target) {
//				l = mid-1;
//				mid = (initial + mid)/2;
//			}else {
//				
//				initial = mid;
//				mid = (l + mid)/2;
//				
//			}
//		}
//		if(nums[mid]==target) {
//			
//			return mid;
//		}else {
//			
//			return -1;
//		}
//	}
	
	// Instead it can be done in this way
	
	public static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid; // Target found, return the index
            } else if (nums[mid] < target) {
                left = mid + 1; // Search in the right half
            } else {
                right = mid - 1; // Search in the left half
            }
        }

        return -1; // Target not found
    }
	
	public static void main(String[] args) {
		
		BinarySearchProblem1 bs = new BinarySearchProblem1();
		
		int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 12, 13, 14, 15, 16, 17, 18, 19, 20};
		int target = 4;
		
		if(bs.binarySearch(nums, target) != -1){
			System.out.println("The index of the target " + target + " is " + bs.binarySearch(nums, target));
		}
		else {
			System.out.println("Element does not exist");
		}
	}

}
