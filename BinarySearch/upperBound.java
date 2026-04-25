import java.util.*;

class UpperBoundFinder {
    // Linear search method to find upper bound
    public int upperBound(int[] arr, int x) {
      int low = 0, high = arr.length - 1;
      int ans = -1;
      while(low < high)
      {
          int mid = (low + high) /2;
          if(arr[mid] > x)
          {
              ans = mid;
              high = mid-1; //first greater value
          }
          else{
              low = mid+1;
          }
      }
      return ans;
      
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 8, 9, 15, 19}; // Sorted array
        int x = 9;

        UpperBoundFinder finder = new UpperBoundFinder();
        int ind = finder.upperBound(arr, x); // Call function

        System.out.println("The upper bound is the index: " + ind); // Output result
    }
}
