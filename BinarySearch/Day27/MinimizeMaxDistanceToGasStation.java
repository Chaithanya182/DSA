/*
KEYNOTE: Binary search on answer space [0, 1e9].
For each distance, calculate total extra fuel needed.
Use formula: for each gap, add (gap - 100) extra fuel.
Find minimum distance where extra fuel needed <= 0.
*/

public class MinimizeMaxDistanceToGasStation {
    public static void main(String[] args) {
        int[] stations = {0, 100, 200, 300, 400, 500, 600};
        int k = 3;
        System.out.println("Minimum max distance: " + minMaxDist(stations, k));
    }
    
    public static double minMaxDist(int[] stations, int k) {
        double low = 0;
        double high = stations[stations.length - 1] - stations[0];
        double ans = high;
        
        for (int i = 0; i < 100; i++) {  // Precision
            double mid = (low + high) / 2;
            
            if (canPlace(stations, k, mid)) {
                ans = mid;
                high = mid;
            } else {
                low = mid;
            }
        }
        return ans;
    }
    
    public static boolean canPlace(int[] stations, int k, double dist) {
        int count = 0;
        for (int i = 0; i < stations.length - 1; i++) {
            double gap = stations[i + 1] - stations[i];
            count += Math.ceil(gap / dist) - 1;
        }
        return count <= k;
    }
}