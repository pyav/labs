/**
 * Following program calculates the maximum price that can be obtained by
 * selling the pieces cut from a rod of length n given the price list.
 * 
 * @author pyav
 *
 */

public class RodCuttingRecursive {

	static int calcMax(int a, int b) {
		return (a > b ? a : b);
	}

	static int calcValue(int priceList[], int len) {

		if (len <= 0) {
			return 0;
		}

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < len; i++) {
			max = calcMax(max, priceList[i] + calcValue(priceList, len - i - 1));
		}

		return max;
	}

	public static void main(String[] args) {
		int priceList[] = { 1, 5, 8, 9, 10, 17, 17, 20 };
		System.out.println("Maximum obtainable value: " + calcValue(priceList, priceList.length));
	}

}
