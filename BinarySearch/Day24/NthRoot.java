/*
KEYNOTE: Similar to square root but with power k. 
Check mid^k <= n using fast exponentiation to avoid overflow.
Binary search on answer space [1, n].
*/

public class NthRoot {
    public static void main(String[] args) {
        int n = 27;
        int k = 3;
        int ans = (int) findNthRoot(n, k);
        System.out.println(k + "th root of " + n + " is: " + ans);
    }
    
    public static double findNthRoot(int n, int k) {
        double low = 1, high = n;
        double ans = 0;
        
        for (int i = 0; i < 100; i++) {  // Precision iterations
            double mid = (low + high) / 2;
            double power = Math.pow(mid, k);
            
            if (power <= n) {
                ans = mid;
                low = mid;
            } else {
                high = mid;
            }
        }
        return ans;
    }
}