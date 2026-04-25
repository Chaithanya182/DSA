/*
KEYNOTE: Binary search on distance [1, max-min].
Place cows greedily: place first at stall[0], then find next stall 
with distance >= mid. Count how many cows can be placed.
Find maximum minimum distance where all cows can be placed.
*/

import java.util.Arrays;

public class AggressiveCows {
    public static void main(String[] args) {
        int[] stalls = {1, 2, 8, 4, 9, 3};
        int cows = 3;
        System.out.println("Maximum minimum distance: " + aggressiveCows(stalls, cows));
    }
    
    public static int aggressiveCows(int[] stalls, int cows) {
        Arrays.sort(stalls);
        
        int low = 1;
        int high = stalls[stalls.length - 1] - stalls[0];
        int ans = 0;
        
        while (low <= high) {
            int mid = (low + high) / 2;
            
            if (canPlaceCows(stalls, cows, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
    
    public static boolean canPlaceCows(int[] stalls, int cows, int dist) {
        int count = 1;
        int lastPos = stalls[0];
        
        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPos >= dist) {
                count++;
                lastPos = stalls[i];
                if (count >= cows) {
                    return true;
                }
            }
        }
        return false;
    }
}