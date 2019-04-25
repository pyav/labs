/**
 * Following program is a solution to the problem #A asked in Codeforces Round #554 (Div. 2).
 * 
 * Output
 * ------
 * 
 */

package codeforces;

import java.util.Scanner;

public class NekoFindsGrapes {

	private static int isOdd(int a) {
		return a % 2;

	}

	private static int min(int a, int b) {
		return (a > b) ? b : a;
	}

	public static void main(String[] args) {
		Scanner obj = new Scanner(System.in);
		int oddCountN = 0, evenCountN = 0;
		int oddCountM = 0, evenCountM = 0;

		int n = obj.nextInt();
		int m = obj.nextInt();

		for (int i = 0; i < n; i++) {
			if (isOdd(obj.nextInt()) == 1) {
				oddCountN += 1;
			} else {
				evenCountN += 1;
			}
		}

		for (int i = 0; i < m; i++) {
			if (isOdd(obj.nextInt()) == 1) {
				oddCountM += 1;
			} else {
				evenCountM += 1;
			}
		}

		obj.close();
		System.out.println(min(evenCountN, oddCountM) + min(oddCountN, evenCountM));
	}

}
