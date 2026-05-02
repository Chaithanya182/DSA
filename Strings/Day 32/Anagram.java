/* KEY NOTE: Two strings are anagrams if they have same characters with same frequencies.
 * Main rule: Equal lengths and identical character frequency counts.
 * Pattern/intuition: Use frequency arrays or maps to count occurrences.
 * Common mistake: Forgetting to check string lengths first.
 * Memory trick: "Same letters, same counts."
 * Time: O(n), Space: O(1) for fixed alphabet size.
 */

// bruteforce approach: sort both strings and compare


import java.util.*;

public class Solution {

    // Function to check if two strings are anagrams
    public static boolean CheckAnagrams(String str1, String str2) {
       int m = str1.length() , n = str2.length();
       
       if( m != n) return false;
       
       char arr1[] = str1.toCharArray();
       char arr2[] = str2.toCharArray();
       
       Arrays.sort(arr1);
       Arrays.sort(arr2);
       
       String sorted1 = new String(arr1);
       String sorted2 = new String(arr2);
       
       return sorted1.equals(sorted2);
       
    }

    public static void main(String[] args) {
        // Example strings to check if they are anagrams
        String Str1 = "INTEGER";
        String Str2 = "TEGERNI";

        // Check if the strings are anagrams and output the result
        if (CheckAnagrams(Str1, Str2)) {
            System.out.println("True");  // Output "True" if they are anagrams
        } else {
            System.out.println("False");  // Output "False" if they aren't anagrams
        }
    }
}



// optimal approach: count frequency of each character in both strings and compare counts
import java.util.*;

public class Solution {

    // Function to check if two strings are anagrams
    public static boolean CheckAnagrams(String str1, String str2) {
       int m = str1.length() , n = str2.length();
       
       if( m != n) return false;
       
       int[] arr = new int[26];
       
       for(int i=0;i<m;i++)
       {
           arr[str1.charAt(i) - 'A']++;
           arr[str2.charAt(i) - 'A']--;
       }
       
       for(int i : arr)
       {
           if(i != 0)
           {
               return false;
           }
       }
       
       return true;
    }

    public static void main(String[] args) {
        // Example strings to check if they are anagrams
        String Str1 = "INTEGER";
        String Str2 = "TEGERNI";

        // Check if the strings are anagrams and output the result
        if (CheckAnagrams(Str1, Str2)) {
            System.out.println("True");  // Output "True" if they are anagrams
        } else {
            System.out.println("False");  // Output "False" if they aren't anagrams
        }
    }
}
