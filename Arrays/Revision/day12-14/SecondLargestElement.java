// Problem: Second Largest Element in Array
// Key Notes:
// - Find largest first, then find largest element excluding largest
// - Or: Compare with both max and secondMax while iterating
// - Time: O(n), Space: O(1)

public class SecondLargestElement {
    public static int findSecondLargest(int[] arr) {
        if (arr.length < 2) return -1;
        
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        
        for (int num : arr) {
            if (num > max) {
                secondMax = max;
                max = num;
            } else if (num > secondMax && num != max) {
                secondMax = num;
            }
        }
        
        return secondMax == Integer.MIN_VALUE ? -1 : secondMax;
    }
}
