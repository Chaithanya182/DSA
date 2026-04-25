class Solution {

    public boolean thresholdValue(int[] nums, int divisor , int threshold)
    {
        long sum = 0;

        for(int i : nums)
        {
            sum += ( i + divisor -1)/(divisor);
            if(sum > threshold) return false;
        }

        return true;

    }

    public int smallestDivisor(int[] nums, int threshold) {
        
        int low = 1 , high = -1;
        int ans = -1;
        for(int i : nums)
        {
            high = Math.max(i, high);
        }

        while(low <= high)
        {
            int mid = low + (high-low)/2; 
            if(thresholdValue(nums,mid,threshold))
            {
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }

        return ans;


    }
}