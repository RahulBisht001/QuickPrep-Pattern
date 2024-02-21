
## **Range Query**


 `Questions`
1. [Range sum query Mutable](https://leetcode.com/problems/range-sum-query-mutable/description/)


`Implementation`

```
Definition

 Segment Tree is a Binary tree that has information about the intervals
 as well as the operation we are performing on it.


 Every Node of Segment tree has two information
 1. Interval
 2. Query


 Segment tree is a Full Binary Tree
 leaf nodes = n
 internal nodes = n-1
 total nodes = 2*n-1

 ______  Query _______

 we can have three cases

 Case 1: Node interval lies inside my query interval.

 (basically it means that whatever interval range lies on
 this node is totally / a part of actual query interval)
 in this case, we will directly return the ans stored at this node.
 e.g., range (4,5) lies inside (2,6)


 Case 2: Node interval is completely outside query interval.

 Node startIdx > query endIdx
 or
 Node endIdx < query startIdx

 here return the default value of the query in this case as this is useless for us.


 Case 3: Overlapping case

 it can be full overlapping or partial.
 e.g: (6,7) or (0,3)etc are example of partial overlapping for query (2,6)
 while (0,7) is full overlapping.In the second case, there are some extra
 elements in our answer.

 here we can ask answer from a left and right node and then deduce our answer.


 for the worst case query, it will take O(log(n)) time as
 a segment tree is a full binary tree and its height is log(n).


 _______ Update query ________

 if update index lies in the range, make update according to the operation.
 else return the old value

 in the end, you will reach to the leaf and update the index value
```
