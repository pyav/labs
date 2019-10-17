/**
 * This program solves problem #1237A on Codeforces. It was asked in Codeforces Global Round 5 held on October 16, 2019.
 * 
 * Link to the problem statement:
 * -----------------------------
 * https://codeforces.com/contest/1237/problem/A
 * 
 * 
 * @author pyav
 */

import java.util.Scanner;

public class BalancedRatingChanges {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		boolean whatLast = false;

		for (int i = 0; i < n; i++) {
			int a = in.nextInt();
			float half = (float) (a / 2.0);
			if (half != Math.floor(half)) {
				if (whatLast) { // true that last fraction value was increased
					whatLast = false;
					System.out.println((int) Math.floor(half));
				} else {
					whatLast = true;
					System.out.println((int) Math.ceil(half));
				}
			} else {
				System.out.println((int) half);
			}

		}

		in.close();
	}

}
