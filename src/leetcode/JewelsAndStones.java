import java.util.Arrays;

/**
 * https://leetcode.com/problems/jewels-and-stones/
 * 
 * Output:
 * ------
 * 3
 * 0
 */

public class JewelsAndStones {

	public int numJewelsInStones(String jewels, String stones) {
		int[] count = new int[52];
		Arrays.fill(count, 0);
		int resultCount = 0;

		for (int i = 0; i < jewels.length(); i++) {
			if (jewels.charAt(i) >= 'a') {
				count[jewels.charAt(i) - 'a'] += 1;
			} else {
				count[jewels.charAt(i) - 'A' + 26] += 1;
			}
		}
		
		for (int i = 0; i < stones.length(); i++) {
			if (stones.charAt(i) >= 'a') {
				if (count[stones.charAt(i)-'a'] > 0) {
					resultCount++;
				}
			} else {
				if (count[stones.charAt(i) -'A'+26] > 0) {
					resultCount++;
				}
			}
		}

		return resultCount;
	}

	public static void main(String[] args) {
		System.out.println(new JewelsAndStones().numJewelsInStones("aA", "aAAbbbb"));
		System.out.println(new JewelsAndStones().numJewelsInStones("z", "ZZ"));
	}

}
