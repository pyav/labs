# Heap
A Binary Heap is a Binary Tree with following properties.
1. All levels are completely filled except possibly the last level and the last
   level has all keys as left as possible.
2. A Binary Heap is either Min Heap or Max Heap.

## Operations on a Binary Heap:
Following are the actions done on a min heap:
1. getMin() - O(1)
2. extractMin() - O(log n)
3. decreaseKey() - O(log n)
4. insertKey() - O(log n)
5. deleteKey() - O(log n)
6. minHeapify() - O(log n)

## Applications of Heaps
1. Heapsort - Quicksort is better in practice.
2. Priority Queue - can be efficiently implemented using binary heap because it
                    supports insert, delete, decreaseKey, extractMax operations
                    in O(log n). Binomial Heap and Fibonacci Heap are
                    variations of Binary Heap and these variations perform
                    union in O(log n). Heap implemented Priority Queues are
                    used in graph algorithms like Prims's and Dijkstra's
                    algorithms.
3. Order statistics - Heap data structure can be used for finding kth
                      largest(or smallest) element in an array.

## Binomial Heap
A binomial heap is implemented as a set of binomial trees (compare with a
binary heap, which has a shape of a single binary tree), which are defined
recursively as follows:
1. A binomial tree of order 0 is a single node
2. A binomial tree of order k has a root node whose children are roots of
   binomial trees of orders k − 1, k − 2, ..., 2, 1, 0 (in this order).
### Properties of Binomial Tree
1. A binomial tree of order k has 2^k node
2. A binomial tree of order k has height k
3. A binomial tree of order k has kCd nodes at depth d
4. A binomial tree of order k can be constructed from two tree of order k-1 by
   attaching one of them as the leftmost child of the other tree
5. Each binomial tree in a heap obeys the min heap property
6. There can be at most one binomial tree for each order including zero order.
   This implies that a binomial tree with n nodes consists of at most 1 + log n
   binomial trees.
## Time complexity analysis
| Procedure  |Binary Heap(worst case)|Binomial Heap (worst case)|Fibonacci Heap (amortized)|
|------------|-----------------------|--------------------------|--------------------------|
|Making heap |                       |                          |                          |
|Insert node |                       |                          |                          |
|Find min    |                       |                          |                          |
|Extract min |                       |                          |                          |
|Union       |                       |                          |                          |
|Decrease key|                       |                          |                          |
|Delete node |                       |                          |                          |


