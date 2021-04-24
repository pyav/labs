/**
 * https://codeforces.com/problemset/problem/705/A
 */

package codeforces;

import java.util.Scanner;

public class Hulk {

	public static void main(String[] args) {

		String first = "I hate";
		String mid = "";
		String last = " it";

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		boolean flip = false;

		for (int i = 1; i < n; i++) {
			if (flip) {
				mid += " that I hate";
			} else {
				mid += " that I love";
			}
			flip = !flip;
		}

		System.out.println(first + mid + last);
		in.close();
	}

}
