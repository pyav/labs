/**
 * https://leetcode.com/problems/find-the-original-array-of-prefix-xor/description/
 *
 * Output:
 * ------
 * 5 7 2 3 2 
 * 13 
 */

import java.util.Arrays;

public class FindXor {

    public int[] findArray(int[] pref) {
        int[] result = new int[pref.length];
        result[0] = pref[0];
        for (int i = 1; i < pref.length; i++) {
            result[i] = pref[i]^pref[i-1];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {5,2,0,3,1};
        int[] result = new FindXor().findArray(nums);
        Arrays.stream(result).forEach(e -> System.out.printf("%d ", e));
        System.out.println();
        int[] nums2 = {13};
        int[] result2 = new FindXor().findArray(nums2);
        Arrays.stream(result2).forEach(e -> System.out.printf("%d ", e));
        System.out.println();
    }

}

