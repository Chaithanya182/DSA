/* KEY NOTE: Find maximum nesting depth of parentheses in string.
 * Main rule: Increment counter on '(', decrement on ')', track maximum counter value.
 * Pattern/intuition: Depth represents how deeply nested the parentheses are.
 * Common mistake: Forgetting to handle non-parentheses characters or unbalanced strings.
 * Memory trick: "Count opens, track max depth."
 * Time: O(n), Space: O(1).
 */

class Solution {
    // Method to compute maximum depth of parentheses
    public int maxDepth(String s) {
        
        int cur = 0 ;
        int max = 0;
        
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i) == '(')
            {
                cur+=1;
                max = Math.max(max,cur);
                
            }
            else if(s.charAt(i) == ')')
            {
                cur-=1;
            }
        }
        return max;
    }
}

// Main class to test the function
class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "(1+(2*3)+(((8))/4))+1";
        int result = sol.maxDepth(s);
        System.out.println("Max Depth: " + result);
    }
}
