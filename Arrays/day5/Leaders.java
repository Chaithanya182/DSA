// Leaders in Array Key Note:
// - A leader is greater than all elements to its right
// - Scan from right to left, tracking the maximum seen so far
// - When current element > maxSoFar, it's a leader
// - Time: O(n), Space: O(n) for result list

import java.util.*;

class Solution {
    //Function to find leaders in an array.
    public ArrayList<Integer> leaders(int[] nums) {
        
        // A leader is an element greater than to its all right side element 
        
       //Move from right to left and as last is leader its max intially
    //   later when we find greater element than max update to max and and add to leader
       ArrayList<Integer> leaders = new ArrayList<>();
       int n = nums.length;
       int max = nums[n-1];
       leaders.add(nums[n-1]);
       
       for(int i = n-2; i>=0;i--)
       {
           if(nums[i] > max)
           {
               max = nums[i];
               leaders.add(nums[i]);
           }
       }
       
       Collections.reverse(leaders);
       
       return leaders;
       
    }
}

class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 3, 1, 2};

        // Create an instance of the Solution class
        Solution finder = new Solution();

        // Get leaders using class method
        ArrayList<Integer> ans = finder.leaders(nums);

        System.out.print("Leaders in the array are: ");
        for (int leader : ans) {
            System.out.print(leader + " ");
        }
        System.out.println();
    }
}