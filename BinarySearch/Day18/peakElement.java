/*
 * KEY NOTE: PEAK ELEMENT SEARCH
 *
 * - A peak element is an element greater than its neighbor(s).
 * - Use binary search to find any peak in O(log n) time.
 *
 * Logic:
 * - If nums[mid] < nums[mid+1], a peak must exist to the right.
 *   Move low = mid + 1.
 * - Otherwise, a peak is at mid or to the left.
 *   Move high = mid.
 *
 * When the loop ends, low == high and points to a peak index.
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0 , high = nums.length - 1;

        while(low < high)
        {
            int mid = low + (high-low)/2;

            if(nums[mid] < nums[mid+1]) // peak is in right
            {
                low = mid+1; // remove left half
            }
            else{
                high = mid; // peak is in left or at mid
            }
        }
        return low;

    }
}