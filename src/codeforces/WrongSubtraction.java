/**
 * This is problem #977A on Codeforces.
 */

import java.util.Scanner;

public class WrongSubtraction {

	private static int getFinalNumAfterSubtraction(int num, int key) {

		if (key == 0) {
			return num;
		}

		int lastNum = num % 10;
		if (lastNum == 0) {
			num = num / 10;
			key = key - 1;
		} else {
			if (key < lastNum) {
				num = num - key;
				key = 0;
			} else {
				num = num - lastNum;
				key = key - lastNum;
			}
		}
		return getFinalNumAfterSubtraction(num, key);
	}

	public static void main(String[] args) {

		Scanner obj = new Scanner(System.in);
		int num = obj.nextInt();
		int key = obj.nextInt();
		System.out.println(getFinalNumAfterSubtraction(num, key));
		obj.close();
	}

}
