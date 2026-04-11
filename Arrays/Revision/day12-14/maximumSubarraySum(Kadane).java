import java.util.*;

// Kadane's Algorithm Key Note:
// - Goal: find the maximum sum of a contiguous subarray
// - Maintain a running current sum and reset it to 0 when it becomes negative
// - Track the maximum sum seen so far
// - Works in one pass with O(n) time and O(1) space
// - Important: initialize max with Integer.MIN_VALUE to handle all-negative arrays

class Solution {
    // Function to find maximum sum of subarrays
    public int maxSubArray(int[] nums) {
        
       int max  =Integer.MIN_VALUE;
       
       int cur =0;
       for(int i : nums)
       {
           cur+=i;
           max = Math.max(max,cur);
           if(cur < 0) cur = 0;
       }
       return max;
    }
}

// Separate Main class in same file
public class Main {
    public static void main(String[] args) {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };

        // Create an instance of Solution class
        Solution sol = new Solution();

        int maxSum = sol.maxSubArray(arr);

        // Print the max subarray sum
        System.out.println("The maximum subarray sum is: " + maxSum);
    }
}
