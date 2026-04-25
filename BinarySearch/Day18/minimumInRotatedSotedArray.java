class Solution {
    // Function to find the minimum element using linear search
    public int findMin(int[] nums) {
       int min = Integer.MAX_VALUE;
       int low = 0 , high = nums.length - 1;
       while(low <= high)
       {
           int mid = low + (high - low)/2;
           
           //check if left half is sorted 
           if(nums[low] <= nums[mid])
           {
               
               //store min of min value of sorted array and min value of unsorted one 
                min = Math.min( min , nums[low] );
               
               //eleminate sorted part 
               low = mid+1;
               
           }
           else{
               min = Math.min( min , nums[mid] );
               high = mid - 1;
           }
           
           
       }
       
       return min;
    }
}

public class Main {
    public static void main(String[] args) {

        // Input array
        int[] nums = {4, 5, 6, 7, 0, 1, 2};

        // Create object of Solution
        Solution sol = new Solution();

        // Call function and store result
        int result = sol.findMin(nums);

        // Output the result
        System.out.println("Minimum element is " + result);
    }
}
