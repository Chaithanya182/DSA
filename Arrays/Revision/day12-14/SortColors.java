// Problem: Sort Array of 0's, 1's, and 2's (Dutch National Flag)
// Key Notes:
// - Use three pointers: low, mid, high
// - low tracks position for 0s, high for 2s
// - mid iterates through array
// - Time: O(n), Space: O(1)
// - If arr[mid] == 0: swap with arr[low], low++, mid++
// - If arr[mid] == 2: swap with arr[high], high--
// - If arr[mid] == 1: just mid++

public class SortColors {
    public static void sortColors(int[] arr) {
        int low = 0, mid = 0, high = arr.length - 1;
        
        while (mid <= high) {
            if (arr[mid] == 0) {
                swap(arr, low, mid);
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                swap(arr, mid, high);
                high--;
            }
        }
    }
    
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
