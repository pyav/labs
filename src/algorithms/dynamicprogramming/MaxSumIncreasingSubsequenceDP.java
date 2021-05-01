package algorithms.dynamicprogramming;

/**
 * Following program finds out the maximum sum of increasing subsequence of integers.  
 * 
 * Output
 * ------
 * Max sum for increasing subsequence = 106
 * 
 * 
 * @author pyav
 *
 */

public class MaxSumIncreasingSubsequenceDP {

	public static void main(String[] args) {
		int arr[] = new int[]{1, 101, 2, 3, 100, 4, 5};
		System.out.println("Max sum for increasing subsequence = " + calcMaxSum(arr, arr.length));

	}

	private static int calcMaxSum(int[] arr, int length) {
		
		int maxSum = 0;
		int sum[] = new int[length];
		
		for (int i = 0; i < length; i++) {
			sum[i] = arr[i];
		}
		
		for (int i = 1; i < length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j] 
					&& sum[i] < (sum[j] + arr[i])) {
					sum[i] = sum[j] + arr[i];
				}
				
			}
		}
		
		for (int i = 0; i < length; i++) {
			if (maxSum < sum[i]) {
				maxSum = sum[i];
			}
		}
		
		return maxSum;
	}

}