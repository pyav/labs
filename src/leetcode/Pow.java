/**
 * https://leetcode.com/problems/powx-n/
 *
 * Output:
 * ------
 * 1024.0
 * 9.261000000000001
 * 0.25
 * 1.0
 * Infinity
 * 0.0
 */

public class Pow {

	public double myPow(double x, int n) {
		long newExp = n;
		newExp = (newExp < 0)? newExp * -1: newExp;
		double res = 1.0;

		while (newExp > 0) {
			if (newExp % 2 == 0) {
				x = x * x;
				newExp = newExp / 2;
			} else {
				res = res * x;
				newExp = newExp - 1;
			}
		}
		if (n < 0) {
			res = 1.0/res;
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(new Pow().myPow(2.00000, 10));
		System.out.println(new Pow().myPow(2.10000, 3));
		System.out.println(new Pow().myPow(2.00000, -2));
		System.out.println(new Pow().myPow(1.00000, -2147483648));
		System.out.println(new Pow().myPow(2.00000, 2147483647));
		System.out.println(new Pow().myPow(2.00000, -2147483648));
	}

}
