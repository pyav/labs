/**
 * https://codeforces.com/problemset/problem/749/A 
 */

package codeforces;

import java.util.Scanner;

public class BachgoldProblem {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		System.out.println(n / 2);

		if (n % 2 == 0) {
			for (int i = 0; i < n / 2; i++) {
				System.out.println(2);
			}
		} else {
			for (int i = 0; i < n / 2 - 1; i++) {
				System.out.println(2);
			}
			System.out.println(3);
		}

		in.close();
	}

}
