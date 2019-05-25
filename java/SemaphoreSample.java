/**
 * Following program shows the use of semaphores for synchronizers.
 * 
 * Output
 * ------
 * Value of count = 1
 * Value of count = 2
 * Value of count = 3
 * Value of count = 4
 * Value of count = 5
 * Releasing semaphore for IncCount
 * Value of count = 4
 * Value of count = 3
 * Value of count = 2
 * Value of count = 1
 * Value of count = 0
 * Releasing semaphore for DecCount
 *
 * @author pyav
 */
package javaPrograms;

import java.util.concurrent.Semaphore;

class Count {
	public static int count = 0;
}

class DecCount implements Runnable {

	Semaphore sem;

	DecCount(Semaphore sem) {
		this.sem = sem;
		new Thread(this).start();
	}

	public void run() {
		try {
			this.sem.acquire();
			for (int i = 0; i < 5; i++) {
				Count.count--;
				System.out.println("Value of count = " + String.valueOf(Count.count));
				Thread.sleep(10);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Releasing semaphore for " + this.getClass().getSimpleName());
			this.sem.release();
		}
	}

}

class IncCount implements Runnable {

	Semaphore sem;

	IncCount(Semaphore sem) {
		this.sem = sem;
		new Thread(this).start();
	}

	public void run() {
		try {
			this.sem.acquire();
			for (int i = 0; i < 5; i++) {
				Count.count++;
				System.out.println("Value of count = " + String.valueOf(Count.count));
				Thread.sleep(10);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Releasing semaphore for " + this.getClass().getSimpleName());
			this.sem.release();
		}
	}

}

public class SemaphoreSample {

	public static void main(String[] args) {

		Semaphore sem = new Semaphore(1, true);
		new IncCount(sem);
		new DecCount(sem);
	}

}
