/*
 * 
 * Given a 0-indexed integer array nums of length n and an
 * integer k, return the number of pairs (i, j) such that:
 * 0 <= i < j <= n - 1 and
 * nums[i] * nums[j] is divisible by k.
 * 
 */

import java.util.HashMap;

class Solution2 {
    public long countPairs(int[] nums, int k) {

        long cnt = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; ++i) {
            int a = gcd(nums[i], k);

            for (int key : map.keySet()) {
                if (((a % k) * (key % k) % k) == 0)
                    cnt += map.get(key);
            }
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        return cnt;
    }

    private int gcd(int a, int b) {
        if (a < b)
            return gcd(b, a);
        return b == 0 ? a : gcd(b, a % b);
    }
}