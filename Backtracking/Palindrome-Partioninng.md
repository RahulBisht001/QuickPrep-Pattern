https://leetcode.com/problems/palindrome-partitioning/description/

## solution

```java
class Solution {
    int n;
    List<List<String>> res = new LinkedList<>();

    public List<List<String>> partition(String str) {

        n = str.length();

        LinkedList<String> curr = new LinkedList<>();
        helper(str, 0,curr);

        return res;
    }

    public void helper(String str, int idx,
            LinkedList<String> curr) {

        if (idx == n) {
            res.add(new LinkedList<>(curr));
            return;
        }

        for (int i = idx; i < n; ++i) {
            if (isPalindrome(str, idx, i)) {
                curr.add(str.substring(idx, i+1));
                helper(str, i + 1, curr);
                curr.pollLast();
            }
        }
    }

    public boolean isPalindrome(String str,int s, int e) {

        while (s < e) {
            if (str.charAt(s++) != str.charAt(e--))
                return false;
        }
        return true;
    }
}
```

/**
 * Time Complexity: O(N * 2 ^ N)
 * Space Complexity: O(N ^ 2)
 * 
 * Where 'N' is the length of string.
 */

```java

class Solution {
    public List<List<String>> partition(String s) {

        List<List<String>> answer = new ArrayList<>();

        // Create a boolean dp for checking substing[i..j] is palindrome or not.
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j < 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                }
            }
        }

        // Recursive function to generate all the possible palindromic partitions.
        partitionHelper(s, 0, answer, new ArrayList<>(), dp);

        return answer;
    }

    private void partitionHelper(String s, int start, List<List<String>> answer,
          List<String> currentList,boolean[][] dp) {

        // If start reach the end of String.
        if (start >= s.length()) {

            // Add the current generated Palindromic Partition to answer List.
            answer.add(new ArrayList<>(currentList));
            return;
        }

        for (int k = start; k < s.length(); k++) {

            // Check if substring S[start...k] is Palindrome or not.
            if (dp[start][k]) {

                // Add the substring S[start...k].
                currentList.add(s.substring(start, k + 1));

                // Recurence for rest of the string to get all the palindromic partitions.
                partitionHelper(s, k + 1, answer, currentList, dp);

                // Remove the substring S[start...k] from current partition.
                currentList.remove(currentList.size() - 1);
            }
        }
    }
}
```
