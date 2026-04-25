/*
KEYNOTE: Binary search on max length [max(arr), sum(arr)].
Similar to book allocation but painters paint sequentially.
Find minimum time when k painters paint all boards.
Time = max(sum of partition) * painters count
*/

public class PaintersPartition {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40};
        int k = 2;
        System.out.println("Minimum time: " + paintersPartition(arr, k));
    }
    
    public static int paintersPartition(int[] arr, int k) {
        int low = Integer.MIN_VALUE;
        int high = 0;
        
        for (int num : arr) {
            low = Math.max(low, num);
            high += num;
        }
        
        int ans = high;
        
        while (low <= high) {
            int mid = (low + high) / 2;
            
            if (canPaint(arr, k, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
    
    public static boolean canPaint(int[] arr, int k, long maxLen) {
        int painters = 1;
        long currentLen = 0;
        
        for (int len : arr) {
            if (currentLen + len > maxLen) {
                painters++;
                currentLen = len;
                if (painters > k) {
                    return false;
                }
            } else {
                currentLen += len;
            }
        }
        return true;
    }
}