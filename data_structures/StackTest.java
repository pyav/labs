/**
 * Following program demonstrates a stack push and pop operation. It also 
 * takes care of stack overflow and stack underflow.
 * 
 * Output
 * ------
 * 
 * Stack items are: 
 * 9 8 7 6 5 4 3 2 1 0 
 *
 *
 * @author pyav
 *
 */

class Stack {
	private int stk[] = new int[10];
	private int tos;
	
	Stack() {
		tos = -1;
	}
	
	// Push an item to the stack
	void push(int item) {
		if (tos == 9) {
			System.out.println("Stack Overflow...");
		} else {
			stk[++tos] = item;
		}
	}
	
	// Pop an item from the stack
	int pop() {
		if (tos < 0) {
			System.out.println("Stack Underflow...");
			return 0;
		} else {
			return stk[tos--];
		}
	}
}

public class StackTest {

	public static void main(String[] args) {
		
		int i = 0;
		Stack stck = new Stack();
		
		// Enter data to the stack
		for(; i < 10; i++) {
			stck.push(i);
		}
		
		// Print the stack items
		System.out.println("Stack items are: ");
		for (i = 0; i < 10; i++) {
			System.out.printf("%d ", stck.pop());
		}
    
	}

}
