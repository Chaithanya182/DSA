// KEY NOTE TO REMEMBER: Longest Subarray Sum 0
// PREFIX SUM + HASHMAP
// - Map: prefix -> first index
// - Init: map.put(0, -1)
// - Loop: prefix += arr[i]
// - If map.contains(prefix): len = i - map.get(prefix)
// - Else: map.put(prefix, i)
// - Update maxLen
// WORKS FOR NEGATIVES, ZEROS, POSITIVES!

import java.util.*;

// core logic holder
class Solution {
    // compute length of the longest subarray with sum 0
    public int solve(int[] a) {
        // store best length found so far
        int maxLen = 0;
      
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        int prefixSum = 0;
        hm.put(0,-1);
        
        for(int i=0;i<a.length;i++)
        {
            prefixSum+=a[i];
            
            int required = prefixSum - 0;
            
            if(hm.containsKey(required))
            {
                maxLen = Math.max(maxLen,i - hm.get(required));
            }
            else
            {
            hm.put(prefixSum,i);
            }
            
        }
        
        
        return maxLen;
    }
}

// separate main class
public class Main {
    // program entry
    public static void main(String[] args) {
        // sample input
        int[] a = new int[] {9, -3, 3, -1, 6, -5};
        // compute result
        int ans = new Solution().solve(a);
        // print result
        System.out.println(ans);
    }
}
