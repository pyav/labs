/**
 * This program shows the producer-consumer model with the use of Semaphores.
 * 
 * Output
 * ------
 * Put: 0
 * Got: 0
 * Put: 1
 * Got: 1
 * Put: 2
 * Got: 2
 * Put: 3
 * Got: 3
 * Put: 4
 * Got: 4
 *
 * 
 * @author pyav
 */

import java.util.concurrent.Semaphore;

class Q {

	int n;

	static Semaphore semCon = new Semaphore(0);
	static Semaphore semProd = new Semaphore(1);

	void get() {
		try {
			semCon.acquire();
		} catch (InterruptedException e) {
			System.out.println("Interrupted exception: " + e.getMessage());
		}

		System.out.println("Got: " + n);
		semProd.release();
	}

	void put(int n) {
		try {
			semProd.acquire();
		} catch (InterruptedException e) {
			System.out.println("Interrupted exception: " + e.getMessage());
		}

		this.n = n;
		System.out.println("Put: " + n);
		semCon.release();
	}
}

class Producer implements Runnable {

	Q q;

	Producer(Q q) {
		this.q = q;
		new Thread(this, "Producer").start();
	}

	public void run() {
		for (int i = 0; i < 5; i++) {
			q.put(i);
		}
	}
}

class Consumer implements Runnable {

	Q q;

	Consumer(Q q) {
		this.q = q;
		new Thread(this, "Consumer").start();
	}

	public void run() {
		for (int i = 0; i < 5; i++) {
			q.get();
		}
	}
}

public class ProducerConsumerSemaphores {

	public static void main(String[] args) {

		Q q = new Q();
		new Consumer(q);
		new Producer(q);
	}

}
