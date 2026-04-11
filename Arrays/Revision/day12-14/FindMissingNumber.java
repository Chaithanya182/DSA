// Problem: Find Missing Number
// Key Notes:
// - Array contains n-1 elements from range 1 to n
// - Approach 1: Sum formula - sum(1 to n) - sum of array
// - Approach 2: XOR - XOR all numbers from 1 to n, then XOR with array elements
// - Time: O(n), Space: O(1)

public class FindMissingNumber {
    // Using sum approach
    public static int findMissingSum(int[] arr, int n) {
        long sum = (long) n * (n + 1) / 2;
        long arrSum = 0;
        for (int num : arr) {
            arrSum += num;
        }
        return (int) (sum - arrSum);
    }
    
    // Using XOR approach (handles overflow better)
    public static int findMissingXOR(int[] arr, int n) {
        int xor1 = 0, xor2 = 0;
        for (int i = 1; i <= n; i++) {
            xor1 ^= i;
        }
        for (int num : arr) {
            xor2 ^= num;
        }
        return xor1 ^ xor2;
    }
}
