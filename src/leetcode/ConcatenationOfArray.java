/**
 * https://leetcode.com/problems/concatenation-of-array/
 *
 * Output:
 * ------
 * [1,2,1,1,2,1]
 */

package leetcode;

public class ConcatenationOfArray {

	public int[] getConcatenation(int[] nums) {
	    int n = nums.length;
        int[] ans = new int[2*n];
        for (int i = 0; i < n; i++) {
            ans[i] = ans[i+n] = nums[i];
        }
        return ans;
    }

	public static void main(String[] args) {
	    int[] arr = {1,2,1};
		int[] res = new ConcatenationOfArray().getConcatenation();

		for (int i = 0; i < res.length; i++) {
			System.out.printf("%d ", res[i]);
		}
	}
}
