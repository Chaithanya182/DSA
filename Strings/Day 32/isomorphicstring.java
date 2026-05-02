/* KEY NOTE: Two strings are isomorphic if characters follow same one-to-one mapping pattern.
 * Store last seen position of each character in both strings using two maps.
 * At each position i, last position of s[i] must equal last position of t[i] - ensures bidirectional mapping.
 * Common mistake: Forgetting that mapping must be bidirectional (e.g., "ab" vs "aa" fails).
 * Memory trick: "Same pattern everywhere" - consistency at every step determines isomorphism.
 * Time: O(n), Space: O(1) with fixed 256 character maps.
 */

class Solution {
      // Method to check if two strings are isomorphic
      public boolean isomorphicString(String s, String t) {
        int m1[] = new int[256];
        int m2[] = new int[256];
        
        int n = s.length();
        
        for(int i=0;i<n;i++)
        {
            if(m1[s.charAt(i) - 'a'] != m2[t.charAt(i) - 'a'] ) return false;
            
            
            m1[s.charAt(i) - 'a'] = i+1;
            m2[t.charAt(i) - 'a'] = i+1;
            
        }
        return true;
        
      }
  }
  
  public class Main {
      public static void main(String[] args) {
          // Create instance of Solution class
          Solution solution = new Solution();
  
          // Define input strings
          String s = "paper";
          String t = "title";
  
          // Check if strings are isomorphic
          if (solution.isomorphicString(s, t)) {
              System.out.println("Strings are isomorphic.");
          } else {
              System.out.println("Strings are not isomorphic.");
          }
      }
  }