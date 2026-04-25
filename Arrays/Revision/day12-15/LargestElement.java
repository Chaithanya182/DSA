// Problem: Largest Element in Array
// Key Notes: 
// - Iterate through array once, keep track of max
// - Time: O(n), Space: O(1)

public class LargestElement {
    public static int findLargest(int[] arr) {
        if (arr.length == 0) return -1;
        
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}
