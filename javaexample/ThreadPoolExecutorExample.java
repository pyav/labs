
/**
 * Following program shows the use of ThreadPoolExecutor to add integers from 1 to 10.
 * Note that the output sequence can be different. 
 * 
 * Output
 * ------
 * Got value = 8
 * Got value = 4
 * Got value = 10
 * Got value = 7
 * Got value = 1
 * Got value = 5
 * Got value = 9
 * Got value = 3
 * Got value = 6
 * Got value = 2
 *
 * Total sum = 55, total values = 10
 *
 * 
 * @author pyav
 *
 */

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class Task implements Callable<Integer> {
	private static int count = 0;

	public Integer call() throws Exception {
		count += 1;
		return count;
	}
}

public class ThreadPoolExecutorExample {

	public static void main(String[] args) 
			throws InterruptedException, ExecutionException, TimeoutException {
		ExecutorService pool = new ThreadPoolExecutor(2, 10, 5, TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(15));
		Set<Future<Integer>> valSet = new HashSet<Future<Integer>>();
		int sum = 0;
		int totalCountOfValues = 0;
		int n = 10; // Add numbers till 10

		for (int i = 0; i < n; i++) {
			Future<Integer> future = pool.submit(new Task());
			valSet.add(future);
		}

		for (Future<Integer> future : valSet) {
			Integer val = future.get(10, TimeUnit.SECONDS);
			System.out.printf("Got value = %d\n", val);
			sum += val;
			totalCountOfValues += 1;
		}
		System.out.printf("\nTotal sum = %d, total values = %d", sum, totalCountOfValues);
	}
}
