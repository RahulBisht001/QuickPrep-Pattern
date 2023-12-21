## Questions


`Patterns`

1. Fixed Size window length
   1. [Substring of size 3 with Distinct Characters](https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters/description/)
   2. 
2. variable length window size
   1. [Minimum Window Substring](https://leetcode.com/problems/minimum-window-substring/description/)
   2. [Longest Repeating Character Replacement](https://leetcode.com/problems/longest-repeating-character-replacement/description/)
   3. [Maximum Fruit into Basket](https://leetcode.com/problems/fruit-into-baskets/description/)
  
`Something Different`
1. [Number of Substrings containing all three characters](https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/description/)

### Questions :
   1. [Find All Anagrams](https://leetcode.com/problems/find-all-anagrams-in-a-string/)
   2. [Permutation in a String](https://leetcode.com/problems/permutation-in-string/description/)


1. [Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold](https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/submissions/)
2. [Count Number of Nice Subarrays](https://leetcode.com/problems/count-number-of-nice-subarrays/)
3. [Minimum Size Subarray Sum](https://leetcode.com/problems/minimum-size-subarray-sum/)
4. [First negative integer in every window of size k](https://tinyl.io/7joJ)
5. [Fruits into Baskets](https://tinyl.io/8yHm) `geeksforgeeks`

### Hard
1. [Sliding Window Maximum](https://tinyl.io/7jO9)

----
1.  **Fixed Size Window**
```java
fixed_window()
{
    int low = 0, high = 0, window size = k;
    while (i < size of array)
    {
        // Step 1: Create a window that is one element smaller than the desired window size
        if (high - low + 1 < window size)
        {
            // Generate the window by increasing the high index
            high++;
        }
        // Step 2: Process the window
        else
        {
            // Window size is now equal to the desired window size
            // Step 2a: Calculate the answer based on the elements in the window
            // Step 2b: Remove the oldest element (at low index) from the window for the next window

            // Proceed to the next window by incrementing the low and high indices
        }
    }
}
```


----
```java
variable_window()
{
    int start = 0, end = 0;
    while (end < n)
    {
        // Perform calculations or operations within the window
        /* Case 1: Expand the window
           If the window size is less than the desired value (k), increase the end index
        */
        if (end - start + 1 < k)
        {
            end++;
        }

        /** Case 2: Window of desired size
           If the window size is equal to the desired value (k), process the window and calculate
           the answer
        */
        else if (end - start + 1 == k)
        {
            // Perform the required calculations or operations to obtain the answer
            // Store the answer in a variable (ans)
            end++;
        }

        /** Case 3: Reduce the window size
           If the window size is greater than the desired value (k), adjust the window by
           moving the start index
        */
        else if (end - start + 1 > k)
        {
            while (end - start + 1 > k)
            {
                // Remove calculations or operations involving the element at the start index
                start++;
            }
            // Check if the window size becomes equal to the desired value (k) after adjustment
            if (end - start + 1 == k)
            {
                // Perform calculations or operations and store the answer if necessary
            }
            end++;
        }
    }
    // Return the final answer (ans)
}
```
