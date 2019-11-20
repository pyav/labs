/**
 * Following program prints 'Fizz', 'Buzz' and 'FizzBuzz' at positions divisible by 3, 5 and 15 respectively.
 * This can be optimized by storing the printed values and iterating over them if there are multiple test cases.
 * 
 * 
 * Output
 * ------
 * 1
 * 15
 * 1
 * 2
 * Fizz
 * 4
 * Buzz
 * Fizz
 * 7
 * 8
 * Fizz
 * Buzz
 * 11
 * Fizz
 * 13
 * 14
 * FizzBuzz
 * 
 * 
 * @author pyav
 */

import java.util.Scanner;

public class FizzBuzz {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int T = in.nextInt();

		for (int j = 0; j < T; j++) {

			int N = in.nextInt();
			for (int i = 1; i <= N; i++) {
				
				if (isBothDivisible(i)) {
					System.out.println("FizzBuzz");
				} else if (is3Divisible(i)) {
					System.out.println("Fizz");
				} else if (is5Divisible(i)) {
					System.out.println("Buzz");
				} else {
					System.out.println(i);
				}
			}
		}

		in.close();
	}

	private static boolean isBothDivisible(int i) {
		return (is3Divisible(i)) && (is5Divisible(i));
	}

	private static boolean is5Divisible(int i) {

		if (i % 5 == 0) {
			return true;
		}
		return false;
	}

	private static boolean is3Divisible(int i) {

		if (i % 3 == 0) {
			return true;
		}
		return false;
	}

}
