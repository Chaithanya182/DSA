// Problem: Longest Subarray with Sum K (Positives Only)
// Key Notes:
// - Use two pointers: left and right
// - If sum equals k, update max length
// - If sum < k, increase right pointer
// - If sum > k, decrease left pointer
// - Time: O(n), Space: O(1)

public class LongestSubarraySumKPositives {
    public static int longestSubarrayWithSumK(int[] arr, int k) {
        int left = 0, right = 0;
        int sum = arr[0];
        int maxLen = 0;
        
        while (right < arr.length) {
            if (sum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
                sum -= arr[left];
                left++;
            } else if (sum < k) {
                right++;
                if (right < arr.length) {
                    sum += arr[right];
                }
            } else {
                sum -= arr[left];
                left++;
            }
        }
        
        return maxLen;
    }
}
