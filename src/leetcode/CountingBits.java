/**
 * https://leetcode.com/problems/counting-bits/
 *
 * Output:
 * ------
 * 0 1 1 2 1 2 2 3 1 2 2 3 2 3 3 4 1 2 2 3 2 3 3 4 2 3 3 4 3 4 4 5 1 
 */

package leetcode;

public class CountingBits {

	private double isIdxPowerOfTwo(int idx) {
		return (Math.ceil(Math.log(idx) / Math.log(2)) - Math.floor(Math.log(idx) / Math.log(2)));
	}

	public int[] countBits(int num) {
		int[] arr = new int[(num == 0) ? 1 : num + 1];
		arr[0] = 0;
		int lastPowerOfTwoIdx = 0;

		for (int i = 1; i <= num; i++) {
		    if (0 == isIdxPowerOfTwo(i)) {
                arr[i] = 1;
                lastPowerOfTwoIdx = i;
            } else {
                int diff = i - lastPowerOfTwoIdx;
                arr[i] = arr[diff] + 1;
            }
		}

		return arr;
	}

	public static void main(String[] args) {
		int[] arr = new CountingBits().countBits(32);

		for (int i = 0; i < arr.length; i++) {
			System.out.printf("%d ", arr[i]);
		}
	}
}
