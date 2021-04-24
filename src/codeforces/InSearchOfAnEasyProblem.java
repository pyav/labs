/**
 * This is problem #1030A on Codeforces.
 */

import java.util.Scanner;

public class InSearchOfAnEasyProblem {

	public static void main(String[] args) {

		boolean isHard = false;
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		while (num > 0) {
			if (1 == in.nextInt()) {
				isHard = true;
				break;
			}
			num = num - 1;
		}
		System.out.println(isHard? "HARD": "EASY");
		in.close();
	}

}
