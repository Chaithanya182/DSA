// Problem: Longest Subarray with Sum K (Can have negatives)
// Also known as: Two Sum problem variant
// Key Notes:
// - Use HashMap with prefix sum
// - Store (prefix_sum -> last_index)
// - If prefix_sum - k exists in map, we found a subarray
// - Time: O(n), Space: O(n)
// - Works with negative numbers too

import java.util.*;

public class LongestSubarraySumK {
    public static int longestSubarrayWithSumK(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        int maxLen = 0;
        
        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
            
            if (prefixSum == k) {
                maxLen = i + 1;
            }
            
            if (map.containsKey(prefixSum - k)) {
                maxLen = Math.max(maxLen, i - map.get(prefixSum - k));
            }
            
            if (!map.containsKey(prefixSum)) {
                map.put(prefixSum, i);
            }
        }
        
        return maxLen;
    }
}
