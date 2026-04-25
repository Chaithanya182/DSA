/*
 * KEY NOTE: MINIMUM DAYS TO MAKE M BOUQUETS
 *
 * Problem:
 * - Given bloomDay array and required bouquets m, each bouquet needs k adjacent flowers.
 * - Find the minimum day such that at least m bouquets can be made.
 *
 * Logic:
 * - Binary search on the day value between min(bloomDay) and max(bloomDay).
 * - For each day candidate, count how many bouquets can be formed from adjacent ready flowers.
 * - Use count/k when a block of ready flowers ends.
 * - If bouquets >= m, try an earlier day; otherwise, try a later day.
 *
 * Complexity:
 * - Time: O(n log m), where n = number of flowers and m = max(bloomDay).
 * - Space: O(1)
 */

public class MinimumDaysToMakeMBouquets {

    public static int noOfBouquets(int[] arr, int day, int k) {
        int count = 0;
        int noBouquets = 0;
        for (int i : arr) {
            if (i <= day) {
                count++;
            } else {
                noBouquets += count / k;
                count = 0;
            }
        }

        noBouquets += count / k;
        return noBouquets;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int low = bloomDay[0], high = bloomDay[0];

        for (int i : bloomDay) {
            low = Math.min(i, low);
            high = Math.max(i, high);
        }

        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (noOfBouquets(bloomDay, mid, k) >= m) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] bloomDay = {1, 10, 3, 10, 2};
        int m = 3;
        int k = 1;

        MinimumDaysToMakeMBouquets solver = new MinimumDaysToMakeMBouquets();
        int result = solver.minDays(bloomDay, m, k);
        System.out.println("Minimum days: " + result);
    }
}
