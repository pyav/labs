/**
 * https://leetcode.com/problems/merge-intervals/description/
 * 
 * Output:
 * ------
 * 
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
	public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        List<int[]> result = new ArrayList<>();
        int i = 0;
        
        while (i < intervals.length) {
        	int start = intervals[i][0];
        	int end  = intervals[i][1];
        	int j = i + 1;
        	
        	while (j < intervals.length && intervals[j][0] <= end) {
        		end = Math.max(end, intervals[j][1]);
        		j++;
        	}
        	
        	result.add(new int[] {start, end});
        	i = j;
        }
        
        return result.toArray(new int[result.size()][]);
    }

	public static void main(String[] args) {
		int[][] intervals = {{1,3}, {2,6}, {8,10}, {15,18}};
		int[][] result = new MergeIntervals().merge(intervals);
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++) {
				System.out.printf("%d ", result[i][j]);
			}
			System.out.println();
		}
	}
}
