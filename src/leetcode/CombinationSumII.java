/**
 * https://leetcode.com/problems/combination-sum-ii/description/
 * 
 * Output:
 * ------
 * 1 1 6 
 * 1 2 5 
 * 1 7 
 * 2 6 
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
	
	private void calcTargetCombinations(int[] candidates, int target, List<Integer> curr, List<List<Integer>> res, int index) {
		if (target == 0) {
			res.add(new ArrayList<>(curr));
			return;
		}
		
		if (target < 0 || index >= candidates.length) {
			return;
		}
		
		for (int i = index; i < candidates.length; i++) {
			if (i > index && candidates[i] == candidates[i-1]) {
				continue;
			}
			if (candidates[i] > target) {
				break;
			}
			
			curr.add(candidates[i]);
			calcTargetCombinations(candidates, target - candidates[i], curr, res, i+1);
			curr.remove(curr.size() - 1);
		}
	}
	
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<Integer> curr = new ArrayList<>();
		List<List<Integer>> res = new ArrayList<>();
		
		calcTargetCombinations(candidates, target, curr, res, 0);
		
		return res;
    }

	public static void main(String[] args) {
		int[] candidates = {10,1,2,7,6,1,5};
		int target = 8;
		List<List<Integer>> result = new CombinationSumII().combinationSum2(candidates, target);

		result.stream().forEach(x -> {
			x.stream().forEach(y -> System.out.printf("%d ", y));
			System.out.println();
		});
	}

}
