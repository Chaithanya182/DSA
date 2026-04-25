// Problem: Majority Element-I (Element appearing > n/2 times)
// Key Notes:
// - Approach 1: HashMap - count frequency (Time: O(n), Space: O(n))
// - Approach 2: Boyer-Moore Voting Algorithm (Time: O(n), Space: O(1))
//   - Find candidate: pair up different elements and remove, remaining is candidate
//   - Verify: count occurrences of candidate
// - Problem guarantees majority element exists

import java.util.*;

public class MajorityElement {
    // Using Boyer-Moore Voting Algorithm
    public static int findMajority(int[] arr) {
        int candidate = findCandidate(arr);
        return isValidCandidate(arr, candidate) ? candidate : -1;
    }
    
    private static int findCandidate(int[] arr) {
        int count = 0;
        int candidate = 0;
        
        for (int num : arr) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }
    
    private static boolean isValidCandidate(int[] arr, int candidate) {
        int count = 0;
        for (int num : arr) {
            if (num == candidate) count++;
        }
        return count > arr.length / 2;
    }
}
