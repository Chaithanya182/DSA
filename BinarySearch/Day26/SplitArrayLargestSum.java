/*
KEYNOTE: Binary search on largest sum [max(arr), sum(arr)].
Split array into m subarrays. Keep adding until sum exceeds max,
then start new subarray. Count number of splits needed.
Find minimum largest sum for m splits.
*/

public class SplitArrayLargestSum {
    public static void main(String[] args) {
        int[] nums = {7, 2, 5, 10, 8};
        int m = 2;
        System.out.println("Minimum largest sum: " + splitArray(nums, m));
    }
    
    public static int splitArray(int[] nums, int m) {
        int low = Integer.MIN_VALUE;
        int high = 0;
        
        for (int num : nums) {
            low = Math.max(low, num);
            high += num;
        }
        
        int ans = high;
        
        while (low <= high) {
            int mid = (low + high) / 2;
            
            if (canSplit(nums, m, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
    
    public static boolean canSplit(int[] nums, int m, int maxSum) {
        int splits = 1;
        int currentSum = 0;
        
        for (int num : nums) {
            if (currentSum + num > maxSum) {
                splits++;
                currentSum = num;
                if (splits > m) {
                    return false;
                }
            } else {
                currentSum += num;
            }
        }
        return true;
    }
}