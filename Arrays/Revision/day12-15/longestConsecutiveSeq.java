import java.util.*;

class Solution {
   

    // Function to find the length of the longest consecutive sequence
    // public int longestConsecutive(int[] nums) {
    //     int n = nums.length;
        
    //     Arrays.sort(nums);
        
    //     int cur = 1;
    //     int max = Integer.MIN_VALUE;
        
    //     for(int i =1;i < n ;i++)
    //     {
    //         if (nums[i] == nums[i - 1]) {
    //             // skip duplicates
    //             continue;
    //         }

    //         else if((nums[i] - nums[i-1] )==1)
    //         {
    //             cur+=1 ;
    //             max = Math.max(cur,max);
    //         }
    //         else{
    //             cur =1;
    //         }
    //     }
        
    //     return max;
    
    // tc -> o(nlogn)
    // sc -> o(1)
  
    // }
    
    // 1 2 3 4 5 6 7 12 43
    
    
    //optimal 
    
    
    // apprach:  store all elements in the set for o(1) cheking 
    // our idea is to check the starting elemet of the series that if there is no lesser element than the current
    
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        
        HashSet<Integer> hs = new HashSet<>();
        
        for(int i : nums)
        {
            hs.add(i);
        }
            
        
        int max = 1;
        
        for(int i=0;i<n;i++)
        {
             int curVal = nums[i];
            //So if false it will be starting element of the sequence
            if((hs.contains(curVal -1)) == false)
            {
                
                int cur = 1;
                
                while(hs.contains(curVal+1))
                {
                    cur+=1;

                    curVal+=1;
                }  
                max = Math.max(cur,max);
            }
            
        }
        
        
        
        
        return max;
  
    }
    
    tc -> o(n);
    sc -> o(n)
    
    

    public static void main(String[] args) {
        // Input array of integers
        int[] a = {1,2,3,43,4,12,5,6,7,6};

        // Create an instance of Solution class
        Solution solution = new Solution();

        // Call the function and store the result
        int ans = solution.longestConsecutive(a);
        
        // Output the result
        System.out.println("The longest consecutive sequence is " + ans);
    }
}
