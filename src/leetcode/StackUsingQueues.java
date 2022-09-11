/**
 * https://leetcode.com/problems/implement-stack-using-queues/
 * 
 * Output:
 * ------
 * 4
 * 4
 * 3
 * 2
 * 1
 * true
 */

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {
	
	Queue<Integer> queue;

	StackUsingQueues() {
		queue = new LinkedList<Integer>();
	}

	public void push(int x) {
		queue.add(x);
        int qSize = queue.size();
        while(qSize > 1) {
            int val = queue.poll();
            queue.add(val);
            qSize--;
        }
	}

	public int pop() {
        return queue.poll();
	}

	public int top() {
        return queue.peek();
	}

	public boolean empty() {
        return queue.isEmpty();
	}

	public static void main(String[] args) {
		StackUsingQueues myStack = new StackUsingQueues();
		myStack.push(1);
		myStack.push(2);
		myStack.push(3);
		myStack.push(4);
		System.out.println(myStack.top());
		System.out.println(myStack.pop());
		System.out.println(myStack.pop());
		System.out.println(myStack.pop());
		System.out.println(myStack.pop());
		System.out.println(myStack.empty());
	}

}
