// Problem: Check if Array is Sorted
// Key Notes:
// - Compare each element with next element
// - Sorted: arr[i] <= arr[i+1] for all i
// - Time: O(n), Space: O(1)

public class CheckIfArrayIsSorted {
    public static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
