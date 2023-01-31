/**
 * https://leetcode.com/problems/sort-array-by-increasing-frequency/description/
 *
 * Output:
 * ------
 * 3 1 1 2 2 2 
 */

import java.util.*;
import java.util.Map.Entry;

public class SortArrayByIncreasingFrequency {

    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> mapCount = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			mapCount.put(nums[i], mapCount.getOrDefault(nums[i], 0)+1);
		}
		SortedMap<Integer, List<Integer>> mapList = new TreeMap<Integer, List<Integer>>();
		for (Entry<Integer, Integer> entry : mapCount.entrySet()) {
			List<Integer> list = null;
			if (mapList.containsKey(entry.getValue())) {
				list = mapList.get(entry.getValue());
			} else {
				list = new ArrayList<Integer>();
			}
			list.add(entry.getKey());
			mapList.put(entry.getValue(), list);
		}
		List<Integer> result = new ArrayList<Integer>();
		for (Entry<Integer, List<Integer>> entry : mapList.entrySet()) {
			List<Integer> list = entry.getValue();
			Collections.sort(list, Collections.reverseOrder());
			for (Integer val : list) {
				for (int i = 0; i < entry.getKey(); i++) {
					result.add(val);
				}
			}
		}
		int[] resultArr = new int[result.size()];
		for (int i = 0; i < result.size(); i++) {
		    resultArr[i] = result.get(i);
		}
		
		return resultArr;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,2,2,3};
        int[] result = new SortArrayByIncreasingFrequency().frequencySort(nums);
        for (Integer num : result) {
            System.out.printf("%d ", num);
        }
        System.out.println();
    }

}

