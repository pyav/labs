/**
 * https://leetcode.com/problems/find-median-from-data-stream/
 *
 * Output:
 * ------
 * 1.5
 * 2.0
 */

import java.util.*;

public class MedianFinder {
    private PriorityQueue<Integer> minQ = null;
    private PriorityQueue<Integer> maxQ = null;

    public MedianFinder() {
        minQ = new PriorityQueue<>();
        maxQ = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        maxQ.offer(num);
        minQ.offer(maxQ.poll());
        if (minQ.size() > maxQ.size()) {
            maxQ.offer(minQ.poll());
        }
    }

    public double findMedian() {
        if (minQ.size() == maxQ.size()) {
            return (minQ.peek() + maxQ.peek())/2.0;
        }
        return maxQ.peek();
    }

    public static void main(String[] args) {
        MedianFinder obj = new MedianFinder();
        obj.addNum(1);
        obj.addNum(2);
        System.out.println(obj.findMedian());
        obj.addNum(3);
        System.out.println(obj.findMedian());
    }
}

