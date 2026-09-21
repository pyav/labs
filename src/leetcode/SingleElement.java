/**
 * https://leetcode.com/problems/single-element-in-a-sorted-array/
 *
 * Output:
 * ------
 * 2
 * 10
 */

public class SingleElement {
    public int singleNonDuplicate(int[] nums) {
        int result = 0;
        for (int num : nums){
            result ^= num;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new SingleElement().singleNonDuplicate(new int[]{1,1,2,3,3,4,4,8,8}));
        System.out.println(new SingleElement().singleNonDuplicate(new int[]{3,3,7,7,10,11,11}));
    }
}

