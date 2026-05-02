/* KEY NOTE: Check if goal is a rotation of s by concatenating s with itself.
 * Main rule: s.length() == goal.length() and goal is substring of s+s.
 * Pattern/intuition: All rotations of s are substrings of s+s.
 * Common mistake: Not checking string lengths first.
 * Memory trick: "Double the string, check inside."
 * Time: O(n), Space: O(n) for concatenation.
 */

class Solution {
    // Method to check if one string is a rotation of another
    public boolean rotateString(String s, String goal) {
        //brute 
        // if(s.length() != goal.length()) return false;
        // for(int i=0;i<s.length();i++)
        // {
        //     String rotated = s.substring(i) + s.substring(0,i);
        //     if(rotated.equals(goal))
            
        //     {
        //         return true;
        //     }
            
        // }
        // return false;
        
        //optimal -> idea is to add a string to itself and we check if the updated has goal
        
        String updated = s+s;
        return updated.contains(goal);
    }
}

// Main class to run the test cases
public class Main {
    public static void main(String[] args) {
        // Create instance of Solution
        Solution sol = new Solution();

        System.out.println(sol.rotateString("rotation", "tionrotd"));
    }
}