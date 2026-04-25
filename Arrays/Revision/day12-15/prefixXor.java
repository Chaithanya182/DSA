// KEY NOTE TO REMEMBER: Count Subarrays with XOR = B
// PREFIX XOR + HASHMAP
// - Map: prefixXor -> frequency
// - Init: map.put(0, 1)
// - Loop: prefixXor ^= arr[i]
// - Required = prefixXor ^ B
// - If map.contains(required): count += map.get(required)
// - map.put(prefixXor, map.getOrDefault(prefixXor, 0) + 1)
// - XOR properties: A ^ B = C => A ^ C = B
 
import java.util.*;

class Solution {
    // Function to count subarrays with XOR equal to B
    public int countSubarraysXOR(int[] A, int B) {
        // Initialize count of valid subarrays
        int count = 0;
        int n = A.length;
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        int prefixXor = 0;
        hm.put(prefixXor,1);
        
        for(int i=0;i<n;i++)
        {
            prefixXor^= A[i];
            
            int required = prefixXor ^ B;
            
            if(hm.containsKey(required))
            {
                count+= hm.get(required);
            }
            
            hm.put(prefixXor,hm.getOrDefault(prefixXor,0)+1);
        }
        
        return count;
    }
}

public class Main {
    public static void main(String[] args) {
        // Input array
        int[] A = {4, 2, 2, 6, 4};
        // Target xor
        int B = 6;

        Solution sol = new Solution();
        System.out.println(sol.countSubarraysXOR(A, B));
    }
}
