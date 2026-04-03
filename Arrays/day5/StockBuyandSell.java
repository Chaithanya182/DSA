// This is day 5 of 100 days of java

// for the past 4 days i have been solving patterns math basics , basic recursion , hashing,sorting algorithms,and array easy

// today im doing array medium problems these problems i have solved mostlu once but not confident and now doing consistentl

// this is day 5 

// Apil 4 2026


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
