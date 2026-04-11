// Pascal's Triangle Key Note:
// - Each row builds on the previous row by summing adjacent values
// - Row 0 is [1]; row i has i+1 elements
// - First and last values are always 1
// - Use the previous row to compute the current row in O(rowNum) time

// Pascal's Triangle Key Note:
// - Each row builds on the previous row by summing adjacent values
// - Row 0 is [1]; row i has i+1 elements
// - First and last values are always 1
// - Use the previous row to compute the next row in O(rowNum) time

import java.util.*;
class Solution {
    public List<Integer> generateRow(int rowNum)
    {
        List<Integer> res = new ArrayList<>();
        int ans = 1;

        res.add(ans);

        for (int i = 1; i <= rowNum; i++) {
            ans = ans * (rowNum - i + 1);
            ans /= i;
            res.add(ans);
        }

        return res;
    }
      
    public List<List<Integer>> generate(int numRows) {
         List<List<Integer>> finalAns = new ArrayList<>();
         for(int i = 0; i < numRows;i++)
         {
            finalAns.add(generateRow(i));
         }
         return finalAns;
    }
    
}