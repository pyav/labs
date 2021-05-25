/**
 * This program demos the change of thread name.
 * 
 * Output:
 * ------
 * Current thread: Thread[main,5,main]
 * New thread:Thread[My thread,5,main]
 * 0
 * 1
 * 2
 * 3
 * 4
 */

package multithreading;

public class CurrentThreadNameDemo {

	public static void main(String[] args) {

		Thread t = Thread.currentThread();
		System.out.println("Current thread: " + t);
		t.setName("My thread");
		System.out.println("New thread:" + t);

		for (int i = 0; i < 5; i++) {
			try {
				System.out.println(i);
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
