// Problem: Remove Duplicates from Sorted Array
// Key Notes:
// - Use two pointers: one for unique elements, one for iteration
// - Only works on sorted array
// - Return count of unique elements
// - Time: O(n), Space: O(1)

public class RemoveDuplicates {
    public static int removeDuplicates(int[] arr) {
        if (arr.length == 0) return 0;
        
        int uniqueCount = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                arr[uniqueCount] = arr[i];
                uniqueCount++;
            }
        }
        return uniqueCount;
    }
}
