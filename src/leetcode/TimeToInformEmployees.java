/**
 * https://leetcode.com/problems/time-needed-to-inform-all-employees/
 *
 * Output:
 * ------
 * 1
 * 0
 * 21
 * 3
 * 2560
 */

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class TimeToInformEmployees {
	private int max;
	
    private int calcMaxVal(Map<Integer, List<Integer>> map, int[] informTime, Integer val, int sum) {
    	if (!map.containsKey(val)) {
    		return 0;
    	}
    	sum += informTime[val];
    	
    	if (sum > this.max) {
    		this.max = sum;
    	}
    	for (Integer t : map.get(val)) {
    		calcMaxVal(map, informTime, t, sum);
    	}
    	return max;
	}
	
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
    	int sum = informTime[headID];
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < manager.length; i++) {
            if (manager[i] == -1) {
                continue;
            }
            List<Integer> val = map.getOrDefault(manager[i], new ArrayList<Integer>());
            val.add(i);
            map.put(manager[i], val);
        }        
        int t = 0;
        if (map.containsKey(headID)) {
        	for (Integer val : map.get(headID)) {
        		this.max = Integer.MIN_VALUE;
        		int s = calcMaxVal(map, informTime, val, 0);
        		if (s > t) {
        			t = s;
        		}
        	}
        }
        return sum + t;
    }

	public static void main(String[] args) {
        int[] manager = {2,2,-1,2,2,2};
        int[] informTime = {0,0,1,0,0,0};
        System.out.println(new TimeToInformEmployees().numOfMinutes(6, 2, manager, informTime));
        int[] manager2 = {-1};
        int[] informTime2 = {0};
        System.out.println(new TimeToInformEmployees().numOfMinutes(1, 0, manager2, informTime2));
        int[] manager3 = {1,2,3,4,5,6,-1};
        int[] informTime3 = {0,6,5,4,3,2,1};
        System.out.println(new TimeToInformEmployees().numOfMinutes(7, 6, manager3, informTime3));
        int[] manager4 = {-1,0,0,1,1,2,2,3,3,4,4,5,5,6,6};
        int[] informTime4 = {1,1,1,1,1,1,1,0,0,0,0,0,0,0,0};
        System.out.println(new TimeToInformEmployees().numOfMinutes(15, 0, manager4, informTime4));
        int[] manager5 = {5,9,6,10,-1,8,9,1,9,3,4};
        int[] informTime5 = {0,213,0,253,686,170,975,0,261,309,337};
        System.out.println(new TimeToInformEmployees().numOfMinutes(11, 4, manager5, informTime5));
    }

}
