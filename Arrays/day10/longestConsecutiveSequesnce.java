// Longest Consecutive Sequence Key Note:
// - Find the longest run of consecutive integers in an unsorted array
// - Efficient solution uses a HashSet and expands from the sequence start
// - Time: O(n), Space: O(n)
// - Key insight: only begin expansion when current number is the start of a sequence

import java.util.*;

class Solution {
    // // Function to search for a given number in the array
    // private boolean linearSearch(int[] a, int num) {
    //     for(int i : a)
    //     {
    //         if(i == num)
    //         {
    //             return true;
    //         }
    //     }
    //     return false;
    // }

    // // Function to find the length of the longest consecutive sequence
    // public int longestConsecutive(int[] nums) {
        
    //     int maxValue = 0;
        
        
    //     for(int i : nums)
    //     {
    //         int count = 1;
    //         int x = i;
    //         while(linearSearch(nums, x+i))
    //         {
    //             count+=1;
    //             x++;
    //         }
            
    //         maxValue = Math.max(maxValue,count);
    //     }
        
    //     return maxValue;
    // }
    
    
    //better
    
    //  public int longestConsecutive(int[] nums)
     {
         //sort the array and find the values based on those valeus
         
         Arrays.sort(nums);
         
         int count = 1;
         int maxCount = 0;
         
         
        for(int i = 1; i < nums.length; i++) {

            if(nums[i] == nums[i-1] + 1) {
                count++;  // consecutive
            }
            else if(nums[i] != nums[i-1]) {
                count = 1;  // reset if not duplicate
            }
            // if duplicate → do nothing

            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
         
     }

    //optimal o(n) sc -> o(n) 
     import java.util.*;

class Solution {
    // // Function to search for a given number in the array
    // private boolean linearSearch(int[] a, int num) {
    //     for(int i : a)
    //     {
    //         if(i == num)
    //         {
    //             return true;
    //         }
    //     }
    //     return false;
    // }

    // // Function to find the length of the longest consecutive sequence
    // public int longestConsecutive(int[] nums) {
        
    //     int maxValue = 0;
        
        
    //     for(int i : nums)
    //     {
    //         int count = 1;
    //         int x = i;
    //         while(linearSearch(nums, x+i))
    //         {
    //             count+=1;
    //             x++;
    //         }
            
    //         maxValue = Math.max(maxValue,count);
    //     }
        
    //     return maxValue;
    // }
    
    
    
    //  public int longestConsecutive(int[] nums)
    //  {
    //      //sort the array and find the values based on those valeus
         
    //      Arrays.sort(nums);
         
    //      int count = 1;
    //      int maxCount = 0;
         
         
    //     for(int i = 1; i < nums.length; i++) {

    //         if(nums[i] == nums[i-1] + 1) {
    //             count++;  // consecutive
    //         }
    //         else if(nums[i] != nums[i-1]) {
    //             count = 1;  // reset if not duplicate
    //         }
    //         // if duplicate → do nothing

    //         maxCount = Math.max(maxCount, count);
    //     }

    //     return maxCount;
         
    //  }

        
     public int longestConsecutive(int[] nums)
     {
         HashSet<Integer> hs = new HashSet<>();
         if(nums.length == 0) return 0;
         for(int i : nums)
         {
             hs.add(i);
         }
         
         int maxLen = 0;
         
         for(int i : nums)
         {
            if(!hs.contains(i-1))
            {
                int x = i;
                int count = 1;
                while(hs.contains(x+1))
                {
                    count+=1;
                    x+=1;
                }
                
                maxLen = Math.max(count,maxLen);
            }
         }
         
         return maxLen;
         
     }


    public static void main(String[] args) {
        // Input array of integers
        int[] a = {100, 4, 200, 1, 3, 2};

        // Create an instance of Solution class
        Solution solution = new Solution();

        // Call the function and store the result
        int ans = solution.longestConsecutive(a);
        
        // Output the result
        System.out.println("The longest consecutive sequence is " + ans);
    }
}




    public static void main(String[] args) {
        // Input array of integers
        int[] a = {100, 4, 200, 1, 3, 2};

        // Create an instance of Solution class
        Solution solution = new Solution();

        // Call the function and store the result
        int ans = solution.longestConsecutive(a);
        
        // Output the result
        System.out.println("The longest consecutive sequence is " + ans);
    }
}
