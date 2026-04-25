// Problem: Left Rotate Array by One
// Key Notes:
// - Store first element, shift all elements left, put first at end
// - Time: O(n), Space: O(1)
// - Example: [1,2,3,4,5] -> [2,3,4,5,1]

public class LeftRotateByOne {
    public static void leftRotateByOne(int[] arr) {
        if (arr.length <= 1) return;
        
        int first = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = first;
    }
}
