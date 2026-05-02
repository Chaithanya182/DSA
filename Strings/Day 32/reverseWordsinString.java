/* KEY NOTE: Iterate from end to start
 * Skip trailing spaces, find word end, then find word start by moving left until space
 * Extract substring and append to result with space separator
 * Handles multiple spaces and leading/trailing spaces
 * Time: O(n), Space: O(n) for result
 */

class Solution {
    // Function to reverse the order of words 
    public String reverseWords(String s) {
            StringBuilder sb = new StringBuilder();
            
            int i = s.length()-1;
            //   String s = " amazing coding skills ";
            while(i>=0)
            {
                //keep i at ending char if there is soace at ending 
                
                while(i>=0 && s.charAt(i)== ' ')
                {
                    i--;
                }
                
                int end =  i ;
                
                //now put i to the starting of word so decrease it 
                while(i>=0 && s.charAt(i) != ' ')
                {
                    i--;
                }
                
                String subStr = s.substring(i+1 , end+1);
                
                if(sb.length() > 0)
                {
                    sb.append(" ");
                }
                
                sb.append(subStr);
            }
        return sb.toString();

        }
        
    }

// Driver code
class Main {
    public static void main(String[] args) {
        Solution obj = new Solution();
        String s = " amazing coding skills ";
        System.out.println(obj.reverseWords(s));
    }
}
