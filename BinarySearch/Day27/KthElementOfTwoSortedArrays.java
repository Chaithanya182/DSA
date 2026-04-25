/*
KEYNOTE: Binary search on answer space [1, n1+n2].
Use partition approach: partition1 + partition2 = k.
Check if left1 <= right2 and left2 <= right1.
If not, adjust partitions accordingly.
*/

public class KthElementOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {2, 3, 6, 7, 9};
        int[] nums2 = {1, 4, 8, 10};
        int k = 5;
        System.out.println(k + "th element: " + findKthElement(nums1, nums2, k));
    }
    
    public static int findKthElement(int[] nums1, int[] nums2, int k) {
        if (nums1.length > nums2.length) {
            return findKthElement(nums2, nums1, k);
        }
        
        int low = Math.max(0, k - nums2.length);
        int high = Math.min(k, nums1.length);
        
        while (low <= high) {
            int partition1 = (low + high) / 2;
            int partition2 = k - partition1;
            
            int left1 = partition1 == 0 ? Integer.MIN_VALUE : nums1[partition1 - 1];
            int right1 = partition1 == nums1.length ? Integer.MAX_VALUE : nums1[partition1];
            
            int left2 = partition2 == 0 ? Integer.MIN_VALUE : nums2[partition2 - 1];
            int right2 = partition2 == nums2.length ? Integer.MAX_VALUE : nums2[partition2];
            
            if (left1 <= right2 && left2 <= right1) {
                return Math.max(left1, left2);
            } else if (left1 > right2) {
                high = partition1 - 1;
            } else {
                low = partition1 + 1;
            }
        }
        return -1;
    }
}