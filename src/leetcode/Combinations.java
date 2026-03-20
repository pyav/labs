/**
 * https://leetcode.com/problems/combinations
 * 
 * Output:
 * ------
 * 1 2 3 
 * 1 2 4 
 * 1 2 5 
 * 1 3 4 
 * 1 3 5 
 * 1 4 5 
 * 2 3 4 
 * 2 3 5 
 * 2 4 5 
 * 3 4 5 
 */

import java.util.*;

public class Combinations {
	
	private void calcCombinations(int start, int n, int k, List<Integer> curr, List<List<Integer>> result) {
		if (k == 0) {
			result.add(new ArrayList<>(curr));
			return;
		}
		
		for (int i = start; i <= n; i++) {
			curr.add(i);
			calcCombinations(i+1, n, k-1, curr, result);
			curr.remove(curr.size()-1);
		}
	}

	public List<List<Integer>> combine(int n, int k) {
        List<Integer> curr = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        
        calcCombinations(1, n, k, curr, result);
        
        return result;
    }
	
	public static void main(String[] args) {
		List<List<Integer>> result = new Combinations().combine(5, 3);
		result.stream().forEach(x -> {
			x.stream().forEach(y -> System.out.printf("%d ", y));
			System.out.println();
		});
	}

}
