/* KEY NOTE: Sort the array, then compare first and last strings
 * If first and last match at position i, all strings in between also match there
 * Compare character by character until mismatch
 * Time: O(n*m*log(m)), Space: O(1) excluding result
 */

import java.util.Arrays;

class Solution {
    // Returns the longest common prefix in an array of strings
    public String longestCommonPrefix(String[] v) {
    
        StringBuilder sb = new StringBuilder();
        
        Arrays.sort(v);
        
        String start = v[0];
        String end = v[v.length-1];
        
        for(int i=0 ; i < Math.min(start.length() , end.length()) ; i++)
        {
            if(start.charAt(i) != end.charAt(i))
            {
                break;
            }
            
            sb.append(start.charAt(i));
        }        
        
        
        
        return sb.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        // Create an instance of Solution
        Solution solution = new Solution();

        // Input array of strings
        String[] input = {"interview", "internet", "internal", "interval"};

        // Call method to get result
        String result = solution.longestCommonPrefix(input);

        // Print the longest common prefix
        System.out.println("Longest Common Prefix: " + result); 
    }
}
