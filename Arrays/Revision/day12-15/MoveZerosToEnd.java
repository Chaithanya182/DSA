// Problem: Move Zeros to End
// Key Notes:
// - Use two pointers: one for next non-zero position, one for iteration
// - Swap non-zero with zero position
// - Time: O(n), Space: O(1)
// - Example: [1,0,2,0,3] -> [1,2,3,0,0]

public class MoveZerosToEnd {
    public static void moveZeros(int[] arr) {
        int nonZeroPos = 0;
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                int temp = arr[nonZeroPos];
                arr[nonZeroPos] = arr[i];
                arr[i] = temp;
                nonZeroPos++;
            }
        }
    }
}
