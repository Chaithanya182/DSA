/*
 * LOWER BOUND & UPPER BOUND TRICK FOR COUNTING OCCURRENCES
 *
 * Consider this sorted array:
 * Indices:  0  1  2  3  4  5  6  7  8  9 10
 * Values:   0  0  1  1  1  2  2  2  3  4  8
 *
 * Lower Bound of 1:
 * - Finds the first occurrence of 1 (or the position where 1 should be inserted if not found)
 * - Condition: nums[i] >= target (move left when true)
 * - Result: lb = 2 (index of first 1)
 *
 * Upper Bound of 1:
 * - Finds the position just after the last occurrence of 1
 * - Condition: nums[i] > target (move left when true)
 * - Result: ub = 5 (index where 2 starts)
 *
 * Count of 1's: ub - lb = 5 - 2 = 3
 *
 * This technique efficiently counts occurrences in O(log n) time using binary search.
 */

import java.util.*;

class UpperBoundFinder {
    // Linear search method to find upper bound
    public int upperBound(int[] arr, int x) {
      int low = 0, high = arr.length - 1;
      int ans = -1;
      while(low < high)
      {
          int mid = (low + high) /2;
          if(arr[mid] >= x)
          {
              ans = mid;
              high = mid-1; //first greater or equal value
          }
          else{
              low = mid+1;
          }
      }
      return ans;
      
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 8, 9, 15, 19}; // Sorted array
        int x = 9;

        UpperBoundFinder finder = new UpperBoundFinder();
        int ind = finder.upperBound(arr, x); // Call function

        System.out.println("The upper bound is the index: " + ind); // Output result
    }
}
