package codeforces;

import java.util.Scanner;

public class Elephant {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int a[] = { 5, 4, 3, 2, 1 };
		int min = 0;

		for (int i = 0; i < 5; i++) {
			int q = n / a[i];
			if (q > 0) {
				min += q;
				n = n % a[i];
			}
		}

		System.out.println(min);
		in.close();
	}

}
