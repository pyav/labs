
/**
 * https://leetcode.com/problems/design-circular-queue/ 
 * 
 * Output:
 * ------
 * true
 * true
 * true
 * false
 * 3
 * true
 * true
 * true
 * 5
 * true
 * 2
 * false
 */

public class MyCircularQueue {
	private int front = -1;
	private int rear = -1;
	private int[] queue = null;
	
	public MyCircularQueue(int k) {
        this.queue = new int[k];
    }
    
    public boolean enQueue(int value) {
        if (this.isFull()) {
        	return false;
        }
        if (front == -1) {
        	front = 0;
        }
        rear = (rear+1)%this.queue.length;
        this.queue[rear] = value;
        return true;
    }
    
    public boolean deQueue() {
        if (this.isEmpty()) {
        	return false;
        }
        if (front == rear) {
        	front = rear = -1;
        } else {
        	front = (front+1)%this.queue.length;
        }
        return true;
    }
    
    public int Front() {
        if (front == -1) {
        	return front;
        }
        return queue[front];
    }
    
    public int Rear() {
        if (rear == -1) {
        	return rear;
        }
        return queue[rear];
    }
    
    public boolean isEmpty() {
        if (front == -1) {
        	return true;
        }
        return false;
    }
    
    public boolean isFull() {
    	if (front == -1) {
    		return false;
    	}
        if ((rear+1)%this.queue.length == front) {
        	return true;
        }
        return false;
    }

	public static void main(String[] args) {
		MyCircularQueue obj = new MyCircularQueue(3);
		System.out.println(obj.enQueue(1));
		System.out.println(obj.enQueue(2));
		System.out.println(obj.enQueue(3));
		System.out.println(obj.enQueue(4));
		System.out.println(obj.Rear());
		System.out.println(obj.isFull());
		System.out.println(obj.deQueue());
		System.out.println(obj.enQueue(5));
		System.out.println(obj.Rear());
		System.out.println(obj.isFull());
		System.out.println(obj.Front());
		System.out.println(obj.enQueue(6));
	}

}
