/**
 * https://leetcode.com/problems/majority-element/submissions/2006275053/?envType=study-plan-v2&envId=top-interview-150
 *
 * Otuput:
 * ------
 * 3
 * 2
 * 7
 */

public class MajorityElementIII {
    public int majorityElement(int[] nums) {
        int majorElement = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (majorElement == nums[i]) {
                count++;
            } else {
                if (count == 0) {
                    count = 1;
                    majorElement = nums[i];
                } else {
                    count--;
                }
            }
        }

        return majorElement;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3};
        System.out.println(new MajorityElementIII().majorityElement(nums));
        System.out.println(new MajorityElementIII().majorityElement(new int[] {2,2,1,1,1,2,2,}));
        System.out.println(new MajorityElementIII().majorityElement(new int[] {8,8,7,7,7}));
    }
}

