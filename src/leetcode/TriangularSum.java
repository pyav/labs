/**
 * https://leetcode.com/problems/find-triangular-sum-of-an-array/
 *
 * Output:
 * ------
 * 2
 */

import java.util.List;
import java.util.ArrayList;

public class TriangularSum {

    public int triangularSum(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return (nums[0] + nums[1])%10;
        }
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < n-1; i++) {
            list.add(nums[i] + nums[i+1]);
        }
        int size = list.size();
        while(size > 0) {
            for (int i = 0; i < list.size()-1; i++) {
                int a = list.get(i);
                int b = list.get(i+1);
                list.remove(i);
                list.add(i, (a+b)%10);
            }
            size -= 1;
            if (size > 0) {
                list.remove(size);
            }
        }

        return list.get(0);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        System.out.println(new TriangularSum().triangularSum(nums));
    }

}

