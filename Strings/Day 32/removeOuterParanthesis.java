/* KEY NOTE: Use a level counter to track nesting depth
 * Add '(' only if level > 0 (not outermost)
 * Decrement level first on ')', then add if level > 0 (not closing outermost)
 * Time: O(n), Space: O(n) for result
 */

class Solution {

    // Function to remove outer parentheses
    public String removeOuterParentheses(String s) {
       StringBuilder sb = new StringBuilder();
       
       int level = 0;
       
       for(char c : s.toCharArray())
       {
           if( c == '(')
           {
               if(level > 0) sb.append(c);
               level++;
           }
           else{
               level--;
               if(level > 0) sb.append(c);
           }
       }
       
       return sb.toString();
       
    }
}            

public class Main {
    public static void main(String[] args) {
        String s = "(()())(())";  // Example input string
        Solution sol = new Solution();

        // Get result
        String ans = sol.removeOuterParentheses(s);

        // Print result
        System.out.println("The result is: " + ans);
    }
}