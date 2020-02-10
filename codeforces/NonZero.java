/*
 * https://codeforces.com/contest/1300/problem/A
 */

import java.util.Scanner;

public class NonZero {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int t = in.nextInt();

		for (int i = 0; i < t; i++) {
			int sum = 0;
			int countProd = 0;
			int n = in.nextInt();

			for (int j = 0; j < n; j++) {
				int a = in.nextInt();

				if (a == 0) {
					countProd += 1;
				}

				sum += a;
			}

			if (sum + countProd == 0) {
				System.out.println(countProd + 1);
			} else {
				System.out.println(countProd);
			}
		}

		in.close();
	}

}
