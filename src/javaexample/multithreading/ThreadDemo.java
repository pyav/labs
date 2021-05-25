/**
 * This program shows multi-threaded execution.
 * 
 * Output:
 * ------
 * Child thread: Thread[Child Thread,5,main]
 * Child thread: 0
 * Main thread: 5
 * Main thread: 4
 * Child thread: 1
 * Main thread: 3
 * Main thread: 2
 * Child thread: 2
 * Main thread: 1
 * Main thread: 0
 * Child thread: 3
 * Exiting Main thread!
 * Child thread: 4
 * Exiting child thread!
 */

package multithreading;

class NewThread implements Runnable {
	Thread t;

	NewThread() {
		t = new Thread(this, "Child Thread");
		System.out.println("Child thread: " + t);
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			try {
				System.out.println("Child thread: " + i);
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				System.out.println("Exception in child.");
				e.printStackTrace();
			}
		}
		System.out.println("Exiting child thread!");
	}

}

public class ThreadDemo {

	public static void main(String[] args) {
		NewThread nt = new NewThread();
		nt.t.start();

		for (int i = 5; i >= 0; i--) {
			try {
				System.out.println("Main thread: " + i);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("Exception in Main thread.");
				e.printStackTrace();
			}
		}
		System.out.println("Exiting Main thread!");

	}

}
