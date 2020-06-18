package leetcode;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

		int max = candies[0];
		for (int i = 1; i < candies.length; i++) {
			if (max < candies[i]) {
				max = candies[i];
			}
		}

		List<Boolean> result = new ArrayList<Boolean>();
		for (int i = 0; i < candies.length; i++) {
			if ((extraCandies + candies[i]) >= max) {
				result.add(true);
			} else {
				result.add(false);
			}
		}

		return result;
	}
}

public class GreatestCandies {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] candies = { 2, 3, 5, 1, 3 };
		List<Boolean> result = new ArrayList<Boolean>();
		result = solution.kidsWithCandies(candies, 3);
		for (int i = 0; i < result.size(); i++) {
			System.out.printf("%s", result.get(i));
		}
	}

}
