/**
 * https://leetcode.com/problems/count-sorted-vowel-strings/
 * 
 * Output:
 * ------
 * 316251
 */

package leetcode;

public class CountSortedVowelStrings {

	public int countVowelStrings(int n) {
		int count[] = { 1, 1, 1, 1, 1 };
		int sum = 0;

		for (int i = 2; i <= n; i++) {
			for (int j = 1; j < 5; j++) {
				count[j] = count[j - 1] + count[j];
			}
		}
		for (int i = 0; i < 5; i++) {
			sum += count[i];
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(new CountSortedVowelStrings().countVowelStrings(50));
	}

}
