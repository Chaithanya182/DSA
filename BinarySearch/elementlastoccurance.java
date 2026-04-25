import java.util.*;

/*
 * KEY NOTE: LAST OCCURRENCE LOGIC
 *
 * - Find the last index of `key` in a sorted list.
 * - When v[mid] == key: record mid, then search right (low = mid + 1).
 * - When v[mid] < key: search right (low = mid + 1).
 * - When v[mid] > key: search left (high = mid - 1).
 * - Result is the rightmost index where v[mid] == key, or -1 if not found.
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

// provides last-occurrence logic
class Solution {
    // find last index of key by scanning from right
    public int solve(int n, int key, List<Integer> v) {
      int low = 0 , high = v.size()-1;
      int ans = -1;
      while(low <= high)
      {
          int mid = (low + high)/2;
          
          if(v.get(mid) == key)
          {
              ans = mid;
              low = mid+1;
          }
          else if(v.get(mid) < key)
          {
              low = mid+1;
          }
          else{
              high = mid-1;
          }
          
      }
      return ans;
    }
}

// separate main class (as requested)
public class Main {
    // program entry
    public static void main(String[] args) {
        // set size
        int n = 7;
        // set key to search
        int key = 13;
        // define input list
        List<Integer> v = Arrays.asList(3, 4, 13, 13, 13, 20, 40);
        // compute answer
        Solution sol = new Solution();
        int ans = sol.solve(n, key, v);
        // print last occurrence index (or -1)
        System.out.println(ans);
    }
}
