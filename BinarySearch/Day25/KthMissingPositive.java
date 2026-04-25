/*
KEYNOTE: Binary search on answer space [1, k + arr.size()].
Use formula: missing = mid - count of elements <= mid.
Find smallest missing positive number > 0.
*/

public class KthMissingPositive {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 7, 11};
        int k = 5;
        System.out.println(k + "th missing positive: " + findKthPositive(arr, k));
    }
    
    public static int findKthPositive(int[] arr, int k) {
        int low = 1;
        int high = k + arr.length;
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            int missing = mid - countLessEqual(arr, mid);
            
            if (missing < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
    
    public static int countLessEqual(int[] arr, int target) {
        int count = 0;
        for (int num : arr) {
            if (num <= target) {
                count++;
            }
        }
        return count;
    }
}