/*
 * KEY NOTE: TIME & SPACE COMPLEXITY
 *
 * Time Complexity: O(log n)
 * - Each binary search (findFloor and findCeil) operates in O(log n) time
 * - getFloorAndCeil performs two binary searches, still O(log n) overall
 *
 * Space Complexity: O(1)
 * - Uses only a constant amount of extra space (a few integer variables)
 * - No additional data structures are created
 */

/*
 * KEY NOTE: FLOOR & CEIL LOGIC
 *
 * Floor (findFloor): Largest element <= x
 * - If arr[mid] <= x: potential candidate, search right (low = mid + 1)
 * - Else: too big, search left (high = mid - 1)
 * - Returns the rightmost valid index
 *
 * Ceil (findCeil): Smallest element >= x
 * - If arr[mid] >= x: potential candidate, search left (high = mid - 1)
 * - Else: too small, search right (low = mid + 1)
 * - Returns the leftmost valid index
 *
 * Both use binary search on sorted array.
 */

import java.util.*;

class FloorCeilFinder {
    // Function to find floor
    public int findFloor(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        int ans = -1;
        
        while(low <= high)
        {
            int mid = (low + high)/2;
            if(arr[mid] <= x)
            {
                ans = mid;
                low = mid+1; // we need last lowest value so move righ
            }
            else{
                high = mid-1;
            }
        }
        
        return ans;
    }

    // Function to find ceiling
    public int findCeil(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        int ans = -1;
        
        while(low <= high)
        {
            int mid = (low + high)/2;
            if(arr[mid] >= x)
            {
                ans = mid;
                high = mid-1; //first greter than or eqaul to value do move left
            }
            else{
                low = mid+1;
            }
        }

        return ans;
    }

    // Function to return floor and ceil as array
    public int[] getFloorAndCeil(int[] arr, int x) {
        int f = findFloor(arr, x);
        int c = findCeil(arr, x);
        return new int[]{f, c};
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 4, 7, 8, 10};
        int x = 5;
        FloorCeilFinder finder = new FloorCeilFinder();
        int[] res = finder.getFloorAndCeil(arr, x);
        System.out.println("The floor and ceil are: " + res[0] + " " + res[1]);
    }
}
