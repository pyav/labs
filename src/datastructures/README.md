# Heap
A Binary Heap is a Binary Tree with following properties.
1. All levels are completely filled except possibly the last level and the last level has all keys as left as possible.
2. A Binary Heap is either Min Heap or Max Heap.

## Operations on a binary heap:
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


