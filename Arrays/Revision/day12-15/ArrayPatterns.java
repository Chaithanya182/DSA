// COMMON PATTERNS IN ARRAYS
// Key patterns to recognize and solve array problems efficiently

/*
================== PATTERN 1: TWO POINTERS ==================
When to use: Sorted array, finding pairs, removing elements, rotating
Examples: 
- Union of sorted arrays
- Remove duplicates from sorted
- Moving zeros to end
- Longest subarray with sum K (positives)

Strategy:
1. One pointer at start, one at end
2. Move pointers based on comparison
3. Time: O(n), Space: O(1)
*/

/*
================== PATTERN 2: PREFIX SUM / CUMULATIVE SUM ==================
When to use: Range sum queries, subarrays with target sum
Examples:
- Longest subarray with sum K (can have negatives)
- Subarray sum equals K
- Find middle index where sum is equal

Strategy:
1. Use HashMap to store prefix sums
2. For each element, check if (prefixSum - target) exists
3. Time: O(n), Space: O(n)
*/

/*
================== PATTERN 3: SLIDING WINDOW ==================
When to use: Contiguous subarrays, max/min in window
Examples:
- Max sum subarray of size k
- Longest subarray with positive numbers
- Minimum window substring

Strategy:
1. Expand window by moving right pointer
2. Shrink from left when condition violated
3. Track result
4. Time: O(n), Space: O(1)
*/

/*
================== PATTERN 4: SORTING/ORDERING ==================
When to use: Rearranging elements, counting sort
Examples:
- Sort 0s, 1s, 2s (Dutch Flag)
- Rearrange alternating positive/negative
- Group by count

Strategy:
1. Identify what determines order
2. Use appropriate sort or multi-pointer approach
3. Time depends on algorithm
*/

/*
================== PATTERN 5: XOR OPERATIONS ==================
When to use: Finding single element, swapping, bit manipulation
Examples:
- Find single number appearing once
- Missing number
- Pairs with XOR = k

Key Properties:
- a XOR a = 0
- a XOR 0 = a
- XOR is commutative and associative
- Time: O(n), Space: O(1)
*/

/*
================== PATTERN 6: LEADER/MAJORITY ELEMENTS ==================
When to use: Finding dominant elements
Examples:
- Majority element > n/2
- Leaders (elements > all right elements)
- Multiple majority elements

Strategy:
- Boyer-Moore for single majority
- Right-to-left scan for leaders
- HashMap for multiple majorities
*/

/*
================== PATTERN 7: ROTATION/REVERSAL ==================
When to use: Array rotation, rearrangements
Examples:
- Left rotate by k
- Right rotate
- Reverse subarrays

Key Insight:
- Left rotate by k = reverse[0:k] + reverse[k:n] reversed again
- Time: O(n), Space: O(1)
*/

/*
================== CONCENTRIC SQUARE PATTERN ==================
Example: Print concentric squares

Input: n = 5
Output:
1 1 1 1 1
1 2 2 2 1
1 2 3 2 1
1 2 2 2 1
1 1 1 1 1

Algorithm:
- For each cell (i, j): min(i+1, j+1, n-i, n-j) gives the layer
- Layers count from outer (1) to inner
- Time: O(n²), Space: O(n²)
*/

public class ArrayPatterns {
    // Example: Concentric Square
    public static void printConcentricSquare(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int layer = Math.min(i, Math.min(j, Math.min(n - 1 - i, n - 1 - j)));
                System.out.print(layer + 1 + " ");
            }
            System.out.println();
        }
    }
}
