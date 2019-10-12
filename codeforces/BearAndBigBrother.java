/**
 * This program solves problem #791A on Codeforces.
 */

import java.util.Scanner;

public class BearAndBigBrother {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		double val = Math.log(b / (float) a) / Math.log(1.5);
		System.out.println((int) (1 + Math.floor(val)));
		in.close();
	}

}
