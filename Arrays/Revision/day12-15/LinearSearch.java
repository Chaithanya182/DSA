// Problem: Linear Search
// Key Notes:
// - Iterate through array and check each element
// - Return index if found, -1 if not found
// - Time: O(n), Space: O(1)
// - Works on unsorted arrays

public class LinearSearch {
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
