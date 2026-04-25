// Problem: Maximum Consecutive Ones
// Key Notes:
// - Count consecutive 1s and keep track of max
// - Reset counter when encounter 0
// - Time: O(n), Space: O(1)
// - Example: [1,1,0,1,1,1] -> 3

public class MaxConsecutiveOnes {
    public static int findMaxConsecutiveOnes(int[] arr) {
        int maxCount = 0;
        int currentCount = 0;
        
        for (int num : arr) {
            if (num == 1) {
                currentCount++;
                maxCount = Math.max(maxCount, currentCount);
            } else {
                currentCount = 0;
            }
        }
        
        return maxCount;
    }
}
