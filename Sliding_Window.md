## Questions


`Patterns`

1. Fixed Size window length
2. variable length window size

### Questions :
   1. [Find All Anagrams](https://leetcode.com/problems/find-all-anagrams-in-a-string/)
   2. [Permutation in a String](https://leetcode.com/problems/permutation-in-string/description/)


----
1.  **Fixed Size Window**
```java
fixed_window()
{
    int low = 0, high = 0, windowsize = k;
    while (i < sizeofarray)
    {
        // Step 1: Create a window that is one element smaller than the desired window size
        if (high - low + 1 < windowsize)
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
