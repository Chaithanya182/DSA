/*
KEYNOTE: Binary search on capacity [max(weights), sum(weights)].
For each capacity, calculate days = sum(weights)/capacity (ceil).
Find minimum capacity that ships within D days.
*/

public class ShipWithinDays {
    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 5;
        System.out.println("Minimum capacity: " + shipWithinDays(weights, days));
    }
    
    public static int shipWithinDays(int[] weights, int days) {
        int low = Integer.MIN_VALUE;
        int high = 0;
        
        for (int weight : weights) {
            low = Math.max(low, weight);
            high += weight;
        }
        
        int ans = high;
        
        while (low <= high) {
            int mid = (low + high) / 2;
            int requiredDays = calculateDays(weights, mid);
            
            if (requiredDays <= days) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
    
    public static int calculateDays(int[] weights, int capacity) {
        int days = 1;
        int current = 0;
        
        for (int weight : weights) {
            if (current + weight > capacity) {
                days++;
                current = weight;
            } else {
                current += weight;
            }
        }
        return days;
    }
}