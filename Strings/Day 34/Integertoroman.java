/* KEY NOTE: Convert integer to Roman numeral using greedy approach.
 * Main rule: Use largest Roman symbol ≤ current number, append and subtract.
 * Pattern/intuition: Predefined value-symbol pairs in descending order handle subtractive notation.
 * Common mistake: Forgetting subtractive cases like 4(IV), 9(IX), 40(XL).
 * Memory trick: "Greedy subtract, build string."
 * Time: O(1), Space: O(1).
 */

class Solution {
    public String intToRoman(int num) {
        int[] values = {
            1000,900,500,400,
            100,90,50,40,
            10,9,5,4,1
        };

        String[] symbols = {
            "M","CM","D","CD",
            "C","XC","L","XL",
            "X","IX","V","IV","I"
        };

        StringBuilder res = new StringBuilder();
        for(int i=0;i<values.length;i++)
        {
            while(num >= values[i])
            {
                res.append(symbols[i]);
                num-=values[i];

            }
        }
    return res.toString();
    }
}