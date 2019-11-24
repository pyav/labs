/**
 * https://codeforces.com/problemset/problem/263/A
 */

package codeforces;

import java.util.Scanner;

public class BeautifulMatrix {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int i = 0, j = 0;

		for (i = 0; i < 5; i++) {
			for (j = 0; j < 5; j++) {
				if (in.nextInt() == 1) {
					System.out.println(Math.abs(i - 2) + Math.abs(j - 2));
					break;
				}
			}

		}

		in.close();
	}

}
