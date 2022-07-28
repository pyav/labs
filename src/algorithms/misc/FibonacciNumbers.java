/**
 *  Following code calculates and prints first 10 Fibonacci numbers in iterative and recursive fashion.
 * 
 * Output:
 * ------
 * First 10 Fibonacci numbers (calculated in iterative fashion) are:
 * 0 1 1 2 3 5 8 13 21 34 
 * 
 * First 10 Fibonacci numbers (calculated in recursive fashion) are:
 * 0 1 1 2 3 5 8 13 21 34 
 */

package coding;

public class FibonacciNumbers {

	public int fibonacciRecursive(int n) {
		if (n <= 1) {
			return n;
		}

		return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
	}

	public void fibonacciIterative(int n) {
		int a = 0;
		int b = 1;
		if (n == 1) {
			System.out.println(a);
		} else if (n >= 2) {
			System.out.printf("%d %d ", a, b);
			for (int i = 0; i < n - 2; i++) {
				int c = a + b;
				System.out.printf("%d ", c);
				a = b;
				b = c;
			}
		} else {
			System.out.println("unknown value");
		}
	}

	public static void main(String[] args) {
		FibonacciNumbers walmart = new FibonacciNumbers();
		System.out.println("First 10 Fibonacci numbers (calculated in iterative fashion) are:");
		walmart.fibonacciIterative(10);
		System.out.println("\n");
		System.out.println("First 10 Fibonacci numbers (calculated in recursive fashion) are:");
		for (int i = 0; i < 10; i++) {
			System.out.printf("%d ", walmart.fibonacciRecursive(i));
		}
	}
}