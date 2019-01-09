/**
 * Following program demonstrates a solution of rod cutting problem using
 * Dynamic Programming concepts.
 * 
 * 
 * Output
 * ------
 * Max value obtainable: 22
 * 
 * 
 * @author pyav
 *
 */

public class RodCuttingDP {

	private static int getMaxCutRod(int[] priceList, int length) {
		int val[] = new int[length + 1];
		val[0] = 0;

		for (int i = 1; i <= length; i++) {
			int maxVal = Integer.MIN_VALUE;
			for (int j = 0; j < i; j++) {
				maxVal = Math.max(maxVal, priceList[j] + val[i - j - 1]);
			}

			val[i] = maxVal;
		}

		return val[length];
	}

	public static void main(String[] args) {
		int priceList[] = { 1, 5, 8, 9, 10, 17, 17, 20 };
		System.out.println("Max value obtainable: " + getMaxCutRod(priceList, priceList.length));
	}

}
