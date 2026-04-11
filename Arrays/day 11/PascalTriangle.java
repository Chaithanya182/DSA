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