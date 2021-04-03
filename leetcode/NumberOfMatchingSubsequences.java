/**
 * https://leetcode.com/problems/number-of-matching-subsequences/
 *
 * Output:
 * ------
 * 3
 */

package leetcode;

import java.util.HashMap;
import java.util.Map;

public class NumberOfMatchingSubsequences {
	private boolean isSubsequence(String s, String t) {
		int j = 0;
		for (int i = 0; i < t.length() && j < s.length(); i++) {
			if (t.charAt(i) == s.charAt(j)) {
				j++;
			}
		}
		if (j < s.length()) {
			return false;
		} else {
			return true;
		}
	}

	public int numMatchingSubseq(String s, String[] words) {
		int matches = 0;
		Map<String, Integer> map = new HashMap<String, Integer>();

		for (int i = 0; i < words.length; i++) {
			if (map.containsKey(words[i])) {
				if (map.get(words[i]) == 1) {
					matches++;
				}
			} else {
				if (isSubsequence(words[i], s)) {
					map.put(words[i], 1);
					matches++;
				} else {
					map.put(words[i], 0);
				}
			}
		}

		return matches;
	}

	public static void main(String[] args) {
		String s = "abcde";
		String[] words = { "a","bb","acd","ace" };
		System.out.println(new NumberOfMatchingSubsequences().numMatchingSubseq(s, words));
	}

}
