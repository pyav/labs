/**
 * https://leetcode.com/problems/minimum-common-value/description/
 *
 * Output:
 * ------
 * 3
 * -1
 */

public class MinCommonValue {
    public int getCommon(int[] nums1, int[] nums2) {
        int minCmVal = -1;

        for (int i = 0, j = 0; i < nums1.length && j < nums2.length;) {
            if (nums1[i] == nums2[j]) {
                minCmVal = nums1[i];
                break;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        return minCmVal;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 5};
        int[] nums2 = {3, 4, 5};
        System.out.println(new MinCommonValue().getCommon(nums1, nums2));
        int[] nums3 = {1, 2, 3, 5};
        int[] nums4 = {4, 6};
        System.out.println(new MinCommonValue().getCommon(nums3, nums4));

    }
}

