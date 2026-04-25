/*
 * KEY NOTE: SINGLE NON-DUPLICATE IN SORTED ARRAY
 *
 * - The array is sorted and every element appears twice except one unique element.
 * - Use binary search on index parity to decide which half contains the single element.
 *
 * Logic:
 * - If mid is even and arr[mid] == arr[mid+1], the single element is to the right.
 * - If mid is odd and arr[mid] == arr[mid-1], the single element is to the right.
 * - Otherwise, the single element is to the left.
 *
 * Edge cases:
 * - Check index 0 and n-1 separately before binary search.
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */
class Solution {
    public int singleNonDuplicate(int[] arr) {
    int n = arr.length;
    if(n == 1) return arr[0];
    //check for 1st and last manually
    if( arr[0] != arr[1]) return arr[0];
    if(arr[n-1] != arr[n-2]) return arr[n-1];


    int low = 1 , high = n-2;
     while(low <= high)
     {
        int mid = low + (high - low)/2;
        //our single element should not be equal to its either elements
        if((arr[mid] != arr[mid-1]) && (arr[mid]) != arr[mid+1])
        {

            return arr[mid];

        }

        //check if we are in left half or right half

        else if( (mid%2 ==0 && arr[mid+1] == arr[mid]) || (mid%2 ==1 && arr[mid-1] == arr[mid]) )
        {

            low = mid+1;

        }

        else{
            high = mid-1;
        }
     }
return -1;
    }
}