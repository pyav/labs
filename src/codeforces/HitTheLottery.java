package codeforces;

import java.util.Scanner;

public class HitTheLottery {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();
		int a[] = { 100, 20, 10, 5, 1 };
		int bills = 0;

		while (n > 0) {
			for (int i = 0; i < a.length; i++) {
				if (n / a[i] > 0) {
					bills += n / a[i];
					n = n % a[i];
				}
			}
		}

		System.out.println(bills);
	}

}
