/*
KEYNOTE: Use binary search on answer space. For square root, 
search in range [0, n]. Check mid*mid <= n to find floor value.
Use precision parameter for decimal results.
*/

public class SquareRoot {
    public static void main(String[] args) {
        long n = 36;
        long ans = floorSqrt(n);
        System.out.println("Square root: " + ans);
    }
    
    // Without precision
    public static long floorSqrt(long n) {
        long low = 1, high = n;
        long ans = 0;
        
        while (low <= high) {
            long mid = (low + high) / 2;
            
            if (mid * mid <= n) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
    
    // With precision
    public static double preciseSqrt(double n, int precision) {
        double low = 0, high = n;
        double ans = 0;
        
        for (int i = 0; i <= precision; i++) {
            double mid = (low + high) / 2;
            double square = mid * mid;
            
            if (square <= n) {
                ans = mid;
                low = mid;
            } else {
                high = mid;
            }
        }
        return ans;
    }
}