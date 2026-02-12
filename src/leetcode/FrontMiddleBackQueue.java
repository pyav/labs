/**
 * https://leetcode.com/problems/design-front-middle-back-queue/
 * 
 * Output:
 * ------
 * 1
 * 3
 * 4
 * 2
 * -1
 */

import java.util.LinkedList;
import java.util.List;

public class FrontMiddleBackQueue {
	
	List<Integer> list = null;
	
	public FrontMiddleBackQueue() {
        list = new LinkedList<>();
    }
    
    public void pushFront(int val) {
        list.addFirst(val);
    }
    
    public void pushMiddle(int val) {
        list.add(list.size()/2, val);
    }
    
    public void pushBack(int val) {
        list.addLast(val);
    }
    
    public int popFront() {
        return (!list.isEmpty())? list.removeFirst(): -1;
    }
    
    public int popMiddle() {
    	if (list.isEmpty()) return -1;
        return list.remove((list.size()-1)/2);
    }
    
    public int popBack() {
        return (!list.isEmpty())? list.removeLast():-1;
    }

	public static void main(String[] args) {
		FrontMiddleBackQueue q = new FrontMiddleBackQueue();
		q.pushFront(1);
		q.pushBack(2);
		q.pushMiddle(3);
		q.pushMiddle(4);
		System.out.println(q.popFront());
		System.out.println(q.popMiddle());
		System.out.println(q.popMiddle());
		System.out.println(q.popBack());
		System.out.println(q.popFront());
	}

}
