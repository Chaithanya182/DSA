// Stock Buy and Sell Key Note:
// - Goal: maximize profit with a single buy and sell
// - Track the minimum price seen so far while iterating
// - Compute profit at each day as current price - minPrice
// - Update maxProfit using the best profit seen so far
// - Time: O(n), Space: O(1)

import java.util.*;

class Solution {
    // Function to calculate max profit using brute force
    public int stockbuySell(int[] prices) {
      int n = prices.length;
      
      int maxProfit = Integer.MIN_VALUE;
      int minPrice = prices[0];
      
      for(int i=1;i<n;i++)
      {
          
        //   two steps : 1.update maxProfit with current - minPrice 
        //   2.update minPrice with current one 
          int currentPrice = prices[i];
          int currentProfit = currentPrice -  minPrice;
          
          
          maxProfit = Math.max(maxProfit,currentProfit);
          
          minPrice = Math.min(minPrice,currentPrice);
          
      }
      return maxProfit;
      
    }
}

// Driver class
class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println("Max Profit: " + sol.stockbuySell(prices));
    }
}
