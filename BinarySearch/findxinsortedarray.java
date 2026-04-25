
import java.util.*;

public class Solution {

    // Function to perform Binary Search on sorted array
    public static int binarySearch(int[] nums, int target) {
        int n = nums.length; // size of the array
        int low = 0, high = n - 1;

        // Keep searching until low crosses high
        while (low <= high) {
            int mid = (low + high) / 2; // Find the middle index
            if (nums[mid] == target) return mid;       // Target found
            else if (target > nums[mid]) low = mid + 1; // Search in right half
            else high = mid - 1;                        // Search in left half
        }
        return -1; // Target not found
    }

    public static void main(String[] args) {
        int[] a = {3, 4, 6, 7, 9, 12, 16, 17}; // sorted array
        int target = 6; // target element to search

        int ind = binarySearch(a, target);

        if (ind == -1)
            System.out.println("The target is not present.");
        else
            System.out.println("The target is at index: " + ind);
    }
}

