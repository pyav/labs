/**
 * https://codeforces.com/problemset/problem/1097/A
 */

package codeforces;

import java.util.Scanner;

public class GennadyAndACardGame {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		String tableVal = in.next();
		boolean isFound = false;

		for (int i = 0; i < 5; i++) {
			String handVal = in.next();
			if ((handVal.charAt(0) == tableVal.charAt(0)) || (handVal.charAt(1) == tableVal.charAt(1))) {
				isFound = true;
				System.out.println("YES");
				break;
			}
		}

		if (!isFound) {
			System.out.println("NO");
		}

		in.close();
	}

}
