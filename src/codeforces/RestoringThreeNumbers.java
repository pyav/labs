package codeforces;

import java.util.Scanner;

public class RestoringThreeNumbers {

	public static void main(String[] args) {

		int a[] = new int[4];
		int max = Integer.MIN_VALUE;
		Scanner in = new Scanner(System.in);

		for (int i = 0; i < 4; i++) {
			a[i] = in.nextInt();
			if (a[i] > max) {
				max = a[i];
			}
		}

		for (int i = 0; i < a.length; i++) {
			if (max != a[i]) {
				System.out.println(max - a[i]);
			}
		}

		in.close();
	}

}
