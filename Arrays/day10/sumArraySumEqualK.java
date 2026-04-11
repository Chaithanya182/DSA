import java.util.*;
class Solution {
    // Function to find count of subarrays with sum equal to k
    public int subarraySum(int[] arr, int k) {
        
        //concept use prefix sum and count all possible sub arrays of having
        // x-k and intution is to consider current prefix sum is x and we should find no of accourences of x-k till now so x - k + k = x =so we will find it and store every occurence of prefix sum in map
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        hm.put(0,1); //base sice intially prefix sum will be zero 
        int n = arr.length;
        int prefixSum = 0;
        int count = 0;
        
        for(int i=0;i<n;i++)
        {
            
            prefixSum+=arr[i];
            
            //calculate x-k is present or not here x-k is the remove
            int remove = prefixSum  - k;
             count += hm.getOrDefault(remove , 0);
            
            hm.put(prefixSum, hm.getOrDefault(prefixSum , 0) +1);
                
        }
        
        return count;
        
    }
}

public class Main {
    public static void main(String[] args) {
        // Input array
        int[] arr = {3, 1, 2, 4};

        // Target sum
        int k = 6;

        // Create Solution object
        Solution sol = new Solution();

        // Call function and store result
        int result = sol.subarraySum(arr, k);

        // Print the count of subarrays
        System.out.println("The number of subarrays is: " + result);
    }
}
