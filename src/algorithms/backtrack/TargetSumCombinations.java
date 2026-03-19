/**
 * Output:
 * ------
 * 1 1 1 1 1 
 * 1 1 1 2 
 * 1 1 3 
 * 1 2 2 
 * 2 3 
 */

import java.util.ArrayList;
import java.util.List;

public class TargetSumCombinations {
	
	private void calcTargetCombinations(int[] arr, int target, List<Integer> curr, List<List<Integer>> res, int index) {
		if (target == 0) {
			res.add(new ArrayList<>(curr));
			return;
		}
		
		if (target < 0 || index >= arr.length) {
			return;
		}
		
		curr.add(arr[index]);
		calcTargetCombinations(arr, target - arr[index], curr, res, index);
		
		curr.remove(curr.size() - 1);
		calcTargetCombinations(arr, target, curr, res, index+1);
	}
	
	private List<List<Integer>> getTargetSumCombinations(int[] arr, int target) {
		List<Integer> curr = new ArrayList<>();
		List<List<Integer>> res = new ArrayList<>();
		
		calcTargetCombinations(arr, target, curr, res, 0);
		return res;
	}

	public static void main(String[] args) {
		int[] arr = {1,2,3};
		int target = 5;
		List<List<Integer>> result = new TargetSumCombinations().getTargetSumCombinations(arr, target);

		for (List<Integer> list : result) {
			list.stream().forEach(x -> System.out.printf("%d ", x));
			System.out.println();
		}
	}

}
