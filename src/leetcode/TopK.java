/**
 * https://leetcode.com/problems/top-k-frequent-elements/description/
 *
 * Output:
 * ------
 * 1 2 3
 */

import java.util.*;

public class TopK {
    public int[] topKFrequent(int[] nums, int k) {
        int[] count = new int[2 * 10000 + 1];
        for (int num : nums) {
            count[num + 10000]++;
        }
        @SuppressWarnings("unchecked")
        List<Integer>[] list = new ArrayList[nums.length + 1];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                list[count[i]].add(i - 10000);
            }
        }
        
        int[] result = new int[k];
        int t = 0;

        for (int i = list.length - 1; i > 0 && k > 0; i--) {
            for (int num : list[i]) {
                if (k == 0) break;
                result[t++] = num;
                k--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
		int[] nums = {1,2,1,2,1,2,3,1,3,2};
		int[] result = new TopK().topKFrequent(nums, 3);
		for (int i = 0; i < result.length; i++) {
			System.out.printf("%d ", result[i]);
		}
		System.out.println();
    }
}

