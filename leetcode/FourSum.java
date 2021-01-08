package leetcode;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> reqdList = new ArrayList<List<Integer>>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            int j = i + 1;
            int k = j + 1;
            while (j < k && k < nums.length-1) {
                int l = nums.length - 1;
                while (k < l) {
                    if (nums[i] + nums[j] + nums[k] + nums[l] > target) {
                        l--;
                    } else if (nums[i] + nums[j] + nums[k] + nums[l] < target) {
                        k++;
                    } else {
                        List<Integer> memberList = new ArrayList<Integer>();
                        memberList.add(nums[i]);
                        memberList.add(nums[j]);
                        memberList.add(nums[k]);
                        memberList.add(nums[l]);
                        Collections.sort(memberList);
                        if (!reqdList.contains(memberList)) {
                            reqdList.add(memberList);
                        }
                        k++;
                        l--;
                    }
                }
                j++;
                k = j+1;
            }
        }

        return reqdList;

    }

    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,-2,2};
		List<List<Integer>> resultList = new FourSum().fourSum(nums, 0);
		for (List<Integer> i : resultList) {
			System.out.printf("%d %d %d %d", i.get(0), i.get(1), i.get(2), i.get(3));
			System.out.println();
		}
    }
}
