/**
 * Link for the problem statement
 * ------------------------------
 * https://codeforces.com/contest/1236/problem/A
 * 
 */

import java.util.Scanner;

public class Stones {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		for (int i = 0; i < n; i++) {
			int max = 0;
			int a = in.nextInt();
			int b = in.nextInt();
			int c = in.nextInt();

			while (c >= 2 && b >= 1) {
				c = c - 2;
				b = b - 1;
				max = max + 3;
			}

			while (b >= 2 && a >= 1) {
				b = b - 2;
				a = a - 1;
				max = max + 3;
			}

			System.out.println(max);
		}

		in.close();
	}

}
