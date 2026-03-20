/**
 * https://leetcode.com/problems/combination-sum-iii
 * 
 *  Output:
 *  ------
 *  1 2 6 
 *  1 3 5 
 *  2 3 4 
 */

import java.util.*;

public class CombinationSumIII {
	
	private void calcCombinations(int start, int n, int k, List<Integer> curr, List<List<Integer>> result) {
		if (k == 0 && curr.stream().mapToInt(Integer::intValue).sum() == n) {
			result.add(new ArrayList<>(curr));
			return;
		}
		
		for (int i = start; i <= 9; i++) {
			curr.add(i);
			calcCombinations(i+1, n, k-1, curr, result);
			curr.remove(curr.size()-1);
		}
	}
	
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<Integer> curr = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        
        calcCombinations(1, n, k, curr, result);
        
        return result;
    }

	public static void main(String[] args) {
		List<List<Integer>> result = new CombinationSumIII().combinationSum3(3, 9);
		result.stream().forEach(x -> {
			x.stream().forEach(y -> System.out.printf("%d ", y));
			System.out.println();
		});
	}

}
