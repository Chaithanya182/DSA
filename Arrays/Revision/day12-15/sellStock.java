// Best Time to Buy and Sell Stock - Key Note:
// - Goal: maximize profit by buying before selling once
// - Track the minimum price seen so far and compute profit at each day
// - Update maxProfit using current price - minPrice
// - Time: O(n), Space: O(1)
// - Important: do not use nested loops; only one pass is needed

class Main {
    public static void main(String[] args) {
        int arr[]  = {7,1,5,3,6,4};
        int n = arr.length;
        
        
        int maxProfit = 0 ;
        int minValue = arr[0];
        
        for(int i=1;i<n;i++)
        {
            maxProfit = Math.max(maxProfit , arr[i] - minValue);
            minValue = Math.min(minValue,arr[i]);
            
        }
        
        System.out.println(maxProfit);
        
        
    }
}