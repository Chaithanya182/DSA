// Problem: Find Number that Appears Once, Others Appear Twice
// Key Notes:
// - Use XOR: a XOR a = 0, a XOR 0 = a
// - XOR all elements, result will be the single number
// - Time: O(n), Space: O(1)
// - Example: [1,2,1,2,3] -> 3 (3 XOR 1 XOR 1 XOR 2 XOR 2 = 3)

public class SingleNumber {
    public static int findSingleNumber(int[] arr) {
        int result = 0;
        for (int num : arr) {
            result ^= num;
        }
        return result;
    }
}
