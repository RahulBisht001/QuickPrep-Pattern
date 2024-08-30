
/**
 * * This question K_Sum is a extended version for 2 sum problem
 * * all problems like 2sum, 3sum ,4sum can be derived from this K_Sum
 * 
 * * 2sum will be the base case for obvious reasons
 * * now this becomes a recursion problem.
 */
import java.util.*;

public class K_Sum {
    public static void main(String[] args) {
        int[] A = { -2, 0, 0, 2, 2 };
        int target = 0;

        Solution s = new Solution();
        List<List<Integer>> results = s.kSum(A, target, 3); // Example for 3-Sum
        System.out.println(results);
    }
}

class Solution {
    public List<List<Integer>> kSum(int[] A, int target, int k) {
        List<List<Integer>> res = new ArrayList<>();

        if (A == null || A.length == 0)
            return res;

        Arrays.sort(A); // Sort the array

        // Start the recursive call
        return kSumHelper(A, 0, target, k);
    }

    private List<List<Integer>> kSumHelper(int[] A, int start, int target, int k) {
        List<List<Integer>> res = new ArrayList<>();

        if (k == 2) {
            // Base case: 2-Sum problem
            int left = start, right = A.length - 1;

            while (left < right) {
                int sum = A[left] + A[right];

                if (sum == target) {
                    // Create a mutable list from the array
                    res.add(new ArrayList<>(Arrays.asList(A[left], A[right])));

                    // Skip duplicates
                    while (left < right && A[left] == A[left + 1])
                        left++;
                    while (left < right && A[right] == A[right - 1])
                        right--;

                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        } else {
            // Recursive case: reduce k-Sum to (k-1)-Sum
            for (int i = start; i < A.length - k + 1; i++) {
                // Avoid duplicates
                if (i > start && A[i] == A[i - 1])
                    continue;

                List<List<Integer>> temp = kSumHelper(A, i + 1, target - A[i], k - 1);

                for (List<Integer> t : temp) {
                    // Prepend the current element to the mutable list
                    List<Integer> current = new ArrayList<>(t);
                    current.add(0, A[i]);
                    res.add(current);
                }
            }
        }

        return res;
    }
}
