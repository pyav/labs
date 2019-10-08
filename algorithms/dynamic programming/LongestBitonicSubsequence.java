/**
 * A Subsequence is Bitonic if it first increases and then decreases.
 * Following program shows a solution to find the length of 
 * longest Bitonic subsequence in an array of positive integers.
 * 
 * Output
 * ------
 * Test 1: The length of longest Bitonic subsequence is: 5
 * Test 2: The length of longest Bitonic subsequence is: 6
 * Test 3: The length of longest Bitonic subsequence is: 5
 * Test 4: The length of longest Bitonic subsequence is: 5
 * Test 5: The length of longest Bitonic subsequence is: 7
 *
 *  
 * @author pyav
 */

public class LongestBitonicSubsequence {

	public static void main(String[] args) {

		int[] arr1 = { 1, 11, 2, 10, 4, 5, 1 };
		System.out.println(
				"Test 1: The length of longest Bitonic subsequence is: " + Integer.toString(lbs(arr1, arr1.length)));
		int[] arr2 = { 1, 11, 2, 10, 4, 5, 2, 1 };
		System.out.println(
				"Test 2: The length of longest Bitonic subsequence is: " + Integer.toString(lbs(arr2, arr2.length)));
		int[] arr3 = { 12, 11, 40, 5, 3, 1 };
		System.out.println(
				"Test 3: The length of longest Bitonic subsequence is: " + Integer.toString(lbs(arr3, arr3.length)));
		int[] arr4 = { 80, 60, 30, 40, 20, 10 };
		System.out.println(
				"Test 4: The length of longest Bitonic subsequence is: " + Integer.toString(lbs(arr4, arr4.length)));
		int[] arr5 = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };
		System.out.println(
				"Test 5: The length of longest Bitonic subsequence is: " + Integer.toString(lbs(arr5, arr5.length)));
	}

	/**
	 * Method to calculate and return the longest Bitonic subsequence (LBS) length.
	 * It first calculates the longest increasing subsequence (lis) till an index in
	 * the array. Then, the longest decreasing subsequence (lds) after the index in
	 * the array. It then adds these two values and stores. These are done for all
	 * the indices in the array. Finally, the max value is searched and returned.
	 * 
	 * @param arr
	 *            The array of positive integers which we need to find the LBS in.
	 * @param length
	 *            Length of the above input array.
	 * @return The Longest Bitonic Subsequence.
	 */
	private static int lbs(int[] arr, int length) {

		// Create an array to store the calculated values
		int[] valArr = new int[length];

		for (int i = 0; i < length; i++) {
			int lisLen = lis(arr, i);
			int ldsLen = lds(arr, i + 1, length);
			valArr[i] = lisLen + ldsLen;
		}

		// Find and return the maximum of the values stored in the above results array
		int max = getMax(valArr, valArr.length);

		return max;
	}
	
	/**
	 * Method to calculate the longest increasing subsequence length.
	 * 
	 * @param arr
	 *            The input array.
	 * @param i
	 *            The last index till which the lis length needs to be calculated.
	 * @return The length of the longest increasing subsequence till the input index
	 *         of the array.
	 */
	private static int lis(int[] arr, int i) {

		int size = i + 1;
		int[] lisLen = new int[size];

		// Initialize the lis len array
		for (int j = 0; j < size; j++) {
			lisLen[j] = 1;
		}

		// Calculate the len array
		for (int j = 1; j < size; j++) {
			for (int k = 0; k < j; k++) {
				if (arr[k] < arr[j] && lisLen[k] + 1 > lisLen[j]) {
					lisLen[j] = lisLen[k] + 1;
				}
			}
		}

		// Find and return max
		int max = getMax(lisLen, lisLen.length);

		return max;
	}

	/**
	 * Method to calculate the longest decreasing subsequence length.
	 * 
	 * @param arr
	 *            The input array.
	 * @param i
	 *            The index which the lds needs to be calculated from.
	 * @param length
	 *            The length of the input array.
	 * @return The length of the longest decreasing subsequence after the input
	 *         index in the array.
	 */
	private static int lds(int[] arr, int startIndex, int length) {

		int size = length - startIndex + 1;
		int[] ldsLen = new int[size];

		// Initialize the lds len array
		for (int j = 0; j < size; j++) {
			ldsLen[j] = 1;
		}

		// Calculate the len array for decreasing subsequence
		for (int j = startIndex + 1; j < length; j++) {
			for (int k = startIndex; k < j; k++) {
				if (arr[k] > arr[j] && ldsLen[k - startIndex] + 1 > ldsLen[j - startIndex]) {
					ldsLen[j - startIndex] = ldsLen[k - startIndex] + 1;
				}
			}
		}

		// Find and return max
		int max = getMax(ldsLen, ldsLen.length);

		return max;
	}

	/**
	 * Method which returns the max value in an array
	 * 
	 * @param arr
	 *            The input array
	 * @param length
	 *            Number of elements in the input array
	 * @return The max value in the input array
	 */
	private static int getMax(int[] arr, int length) {

		int max = Integer.MIN_VALUE;
		for (int j = 0; j < length; j++) {
			if (arr[j] > max) {
				max = arr[j];
			}
		}

		return max;
	}

}
