/**
 * https://leetcode.com/problems/kth-largest-element-in-a-stream/description/
 *
 * Output:
 * ------
 * 4
 * 5
 * 5
 * 8
 * 8
 * 7
 * 7
 * 7
 * 8
 */

package leetcode;
import java.util.*;

public class KthLargestElementInStream {
    private int k;
    PriorityQueue<Integer> pq = null;

    public KthLargestElementInStream(int k, int[] nums) {
        this.k = k;
        this.pq = new PriorityQueue<>();
        
        for (int num : nums) {
            this.pq.add(num);
            if (this.pq.size() > k) {
                this.pq.poll();
            }
        }
    }

    public int add(int val) {
    	if (this.pq.size() < k) {
    		this.pq.add(val);
    		return this.pq.peek();
    	}
    	int currKthLargest = this.pq.peek();
    	if (val <= currKthLargest) {
    		return currKthLargest;
    	}
    	this.pq.poll();
    	this.pq.add(val);
    	return this.pq.peek();
    }

    public static void main(String[] args) {
    	KthLargestElementInStream obj = new KthLargestElementInStream(3, new int[] {4,5,8,2});
    	System.out.println(obj.add(3));
    	System.out.println(obj.add(5));
    	System.out.println(obj.add(10));
    	System.out.println(obj.add(9));
    	System.out.println(obj.add(4));
    	obj = new KthLargestElementInStream(4, new int[] {7, 7, 7, 7, 8, 3});
    	System.out.println(obj.add(2));
    	System.out.println(obj.add(10));
    	System.out.println(obj.add(9));
    	System.out.println(obj.add(9));
    }
}

