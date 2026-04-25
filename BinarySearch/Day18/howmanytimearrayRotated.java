/*
 * KEY NOTE: FIND ROTATION COUNT (FIND MINIMUM IN ROTATED SORTED ARRAY)
 *
 * The rotation count = index of the minimum element.
 * 
 * Logic:
 * - If left half is sorted (nums[low] <= nums[mid]): minimum is in right half, move low.
 * - If left half is NOT sorted: minimum is in left half, move high.
 * - Always track the minimum element found and its index.
 *
 * Example: [4, 5, 6, 7, 0, 1, 2]
 * - Minimum is 0 at index 4.
 * - The array is rotated 4 times.
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

class Solution {

    public int howManyTimesRotated(int[] nums) {
       int min = Integer.MAX_VALUE;
       int low = 0 , high = nums.length - 1;
       int minInd = -1;
       while(low <= high)
       {
           int mid = low + (high - low)/2;
           
           //check if left half is sorted 
           if(nums[low] <= nums[mid])
           {
               
               //store min of min value of sorted array and min value of unsorted one 
                if(nums[low] < min)
                {
                    min = nums[low];
                    minInd = low;
                    
                }
               
               //eleminate sorted part 
               low = mid+1;
               
           }
           else{
               
               if(nums[mid] < min)
               {
                   min = nums[mid];
                   minInd = mid;
               }
               high = mid - 1;
           }
           
           
       }
       
       return minInd;
    }
}

public class Main {
    public static void main(String[] args) {

        // Input array
        int[] nums = {4, 5, 6, 7, 0, 1, 2};

        // Create object of Solution
        Solution sol = new Solution();

        // Call function and store result
        int result = sol.howManyTimesRotated(nums);

        // Output the result
        System.out.println("Minimum element is " + result);
    }
}
