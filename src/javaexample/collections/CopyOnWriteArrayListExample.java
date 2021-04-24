/**
 * Output
 * ------
 * a
 * b
 * c
 * d
 * [a, b, c, d, e]
 */

package collections;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListExample extends Thread {

	static CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>();

	public void run() {
		list.add("d");
	}

	public static void main(String[] args) throws InterruptedException {

		list.add("a");
		list.add("b");
		list.add("c");

		CopyOnWriteArrayListExample obj = new CopyOnWriteArrayListExample();
		obj.run();
		Thread.sleep(1000);

		Iterator<String> itr = list.iterator();
		list.add("e");

		while (itr.hasNext()) {
			System.out.println((String) itr.next());
			Thread.sleep(1000);
		}
		System.out.println(list);
	}

}
