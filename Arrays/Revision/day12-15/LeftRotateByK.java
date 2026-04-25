// Problem: Left Rotate Array by K Places
// Key Notes:
// - Approach 1: Reverse method - reverse first k, reverse rest, reverse all
//   [1,2,3,4,5] k=2 -> [2,1,3,4,5] -> [2,1,5,4,3] -> [3,4,5,1,2]
// - Approach 2: Use temp array
// - Time: O(n), Space: O(1) for reverse method

public class LeftRotateByK {
    // Using reverse method
    public static void leftRotateByK(int[] arr, int k) {
        k = k % arr.length;
        reverse(arr, 0, k - 1);
        reverse(arr, k, arr.length - 1);
        reverse(arr, 0, arr.length - 1);
    }
    
    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
