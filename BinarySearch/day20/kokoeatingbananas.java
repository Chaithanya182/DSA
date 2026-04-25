/*
 * KEY NOTE: KOKO EATING BANANAS (OPTIMAL BINARY SEARCH)
 *
 * Problem:
 * - Given piles of bananas and H hours, find the minimum eating speed K
 *   such that Koko can finish all bananas within H hours.
 *
 * Logic:
 * - Use binary search on the eating speed K, not on the piles themselves.
 * - Lower bound = 1, upper bound = max(piles).
 * - For a candidate speed K, compute hours needed as:
 *     hours = sum((pile + K - 1) / K)
 * - If hours <= H, K is valid; try smaller speeds.
 * - If hours > H, K is too slow; increase speed.
 *
 * Complexity:
 * - Time: O(n log m), where n = number of piles and m = max(pile).
 * - Space: O(1)
 */

import java.util.*;

public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int H) {
        int low = 1;
        int high = 0;
        for (int pile : piles) {
            high = Math.max(high, pile);
        }

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (canFinish(piles, H, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private boolean canFinish(int[] piles, int H, int speed) {
        long hours = 0;
        for (int pile : piles) {
            hours += (pile + speed - 1) / speed;
            if (hours > H) {
                return false;
            }
        }
        return hours <= H;
    }

    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        int H = 8;

        KokoEatingBananas solver = new KokoEatingBananas();
        int minSpeed = solver.minEatingSpeed(piles, H);

        System.out.println("Minimum eating speed: " + minSpeed);
    }
}
