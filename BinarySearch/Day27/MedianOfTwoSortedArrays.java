/*
KEYNOTE: Binary search on partition index in smaller array.
Use two pointers: partition1 in arr1, partition2 in arr2.
Left1 <= Right2 and Left2 <= Right1 ensures correct merge.
Handle odd/even lengths differently for median calculation.
*/

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println("Median: " + findMedianSortedArrays(nums1, nums2));
    }
    
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int low = 0;
        int high = nums1.length;
        
        while (low <= high) {
            int partition1 = (low + high) / 2;
            int partition2 = (nums1.length + nums2.length + 1) / 2 - partition1;
            
            int left1 = partition1 == 0 ? Integer.MIN_VALUE : nums1[partition1 - 1];
            int right1 = partition1 == nums1.length ? Integer.MAX_VALUE : nums1[partition1];
            
            int left2 = partition2 == 0 ? Integer.MIN_VALUE : nums2[partition2 - 1];
            int right2 = partition2 == nums2.length ? Integer.MAX_VALUE : nums2[partition2];
            
            if (left1 <= right2 && left2 <= right1) {
                if ((nums1.length + nums2.length) % 2 == 0) {
                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                } else {
                    return Math.max(left1, left2);
                }
            } else if (left1 > right2) {
                high = partition1 - 1;
            } else {
                low = partition1 + 1;
            }
        }
        return 0.0;
    }
}