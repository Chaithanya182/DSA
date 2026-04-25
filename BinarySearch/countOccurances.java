import java.util.*;

class Solution {

    public static int firstPosition(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] == target) {
                ans = mid;
                high = mid - 1; // move left for first occurrence
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public static int lastPosition(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] == target) {
                ans = mid;
                low = mid + 1; // move right for last occurrence
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }


    // 🔥 MAIN METHOD
    public static void main(String[] args) {
        Solution obj = new Solution();

        int[] nums = {1, 2, 4, 4, 4, 5, 7};
        int target = 5;

	int firstPos = firstPosition(nums,target);
	int lastPos =  lastPosition(nums,target);
	
	System.out.println((lastPos - firstPos) +1);

       
    }
}