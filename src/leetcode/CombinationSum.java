/*
 * https://leetcode.com/problems/combination-sum
 * 
 *  Output:
 *  ------
 *  2 2 3 
 *  7 
 */

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
	
	private void calcTargetCombinations(int[] candidates, int target, List<Integer> curr, List<List<Integer>> res, int index) {
		if (target == 0) {
			res.add(new ArrayList<>(curr));
			return;
		}
		
		if (target < 0 || index >= candidates.length) {
			return;
		}
		
		curr.add(candidates[index]);
		calcTargetCombinations(candidates, target - candidates[index], curr, res, index);
		
		curr.remove(curr.size() - 1);
		calcTargetCombinations(candidates, target, curr, res, index+1);
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<Integer> curr = new ArrayList<>();
		List<List<Integer>> res = new ArrayList<>();
		
		calcTargetCombinations(candidates, target, curr, res, 0);
		return res;
    }

	public static void main(String[] args) {
		int[] candidates = {2,3,6,7};
		int target = 7;
		List<List<Integer>> result = new CombinationSum().combinationSum(candidates, target);

		for (List<Integer> list : result) {
			list.stream().forEach(x -> System.out.printf("%d ", x));
			System.out.println();
		}
	}

}
