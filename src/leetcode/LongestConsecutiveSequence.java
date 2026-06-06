/**
 * https://leetcode.com/problems/longest-consecutive-sequence/
 *
 * Output:
 * ------
 * 4
 * 9
 * 3
 */

import java.util.*;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        
        for (int num : nums) {
            set.add(num);
        }
        
        int longest = 0;
        Iterator<Integer> itr = set.iterator();
        
        while(itr.hasNext()) {
        	int nextVal = itr.next();
        	if (!set.contains(nextVal - 1)) {
        		int start = nextVal;
        		int step = 1;
        		while(set.contains(start + step)) {
        			step++;
        		}
        		longest = Math.max(step, longest);
        	}
        }
        return longest;
    }

    public static void main(String[] args) {
        System.out.println(new LongestConsecutiveSequence().longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(new LongestConsecutiveSequence().longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
        System.out.println(new LongestConsecutiveSequence().longestConsecutive(new int[]{1,0,1,2}));
    }
}

