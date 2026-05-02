/* KEY NOTE: Find last odd digit from right, skip leading zeros from left
 * Largest odd number = substring from first non-zero to last odd digit
 * If no odd digit exists, return empty string
 * Time: O(n), Space: O(1)
 */

import java.util.*;

class Solution {
    // Returns the largest odd number substring from the given string
    public String largeOddNum(String s) {
        int ind = -1;

        // Find the last odd digit in the string
        int i;
        for (i = s.length() - 1; i >= 0; i--) {
            if ((s.charAt(i) - '0') % 2 == 1) {
                ind = i;
                break;
            }
        }

        // Return empty string if no odd digit was found
        if (ind == -1) return "";

        // Skip leading zeroes up to the odd digit
        i = 0;
        while (i <= ind && s.charAt(i) == '0') i++;

        // Return substring from first non-zero to odd digit
        return s.substring(i, ind + 1);
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String num = "504";
        String result = solution.largeOddNum(num);
        System.out.println("Largest odd number: " + result);
    }
}