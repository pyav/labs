/**
 * https://leetcode.com/problems/design-circular-deque/?envType=problem-list-v2&envId=design
 * 
 *  Output:
 *  ------
 *  true
 * true
 * false
 * false
 * 1
 * 2
 * true
 * 2
 * true
 * -1
 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.lang.Exception;
import java.util.NoSuchElementException;

public class DesignCircularDeque {
	
	private Deque<Integer> dq = null;
	private int limit = 0;

	public DesignCircularDeque(int k) {
		dq = new ArrayDeque<>();
		limit = k;
    }
    
    public boolean insertFront(int value) {
        if (dq.size() >= limit) {
        	return false;
        }
        return dq.offerFirst(value);
    }
    
    public boolean insertLast(int value) {
        if (dq.size() >= limit) {
        	return false;
        }
        return dq.offerLast(value);
    }
    
    public boolean deleteFront() {
        if (dq.isEmpty()) {
        	return false;
        }
        try {
        	dq.removeFirst();
        } catch (Exception e) {
        	return false;
        }
        return true;
    }
    
    public boolean deleteLast() {
    	if (dq.isEmpty()) {
        	return false;
        }
    	try {
    		dq.removeLast();
    	} catch (Exception e) {
    		return false;
    	}
    	return true;
    }
    
    public int getFront() {
        try {
        	return dq.getFirst();
        } catch (NoSuchElementException e) {
        	return -1;
        }
    }
    
    public int getRear() {
        try {
        	return dq.getLast();
        } catch (NoSuchElementException e) {
        	return -1;
        }
    }
    
    public boolean isEmpty() {
        return (dq.isEmpty())? true: false;
    }
    
    public boolean isFull() {
        return (limit == dq.size())? true: false;
    }
	
	public static void main(String[] args) {
		DesignCircularDeque dq = new DesignCircularDeque(10);
		System.out.println(dq.insertFront(1));
		System.out.println(dq.insertLast(2));
		System.out.println(dq.isEmpty());
		System.out.println(dq.isFull());
		System.out.println(dq.getFront());
		System.out.println(dq.getRear());
		System.out.println(dq.deleteFront());
		System.out.println(dq.getFront());
		System.out.println(dq.deleteLast());
		System.out.println(dq.getRear());
	}

}
