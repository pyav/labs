/**
 * https://leetcode.com/problems/sort-array-by-parity-ii/description/
 *
 * Output:
 * ------
 * 4 5 2 7 
 * 2 3 
 */

import java.util.Arrays;

public class SortArray {
    public int[] sortArrayByParityII(int[] nums) {
        int odd = 1, even = 0;
        int[] result = new int[nums.length];

        for (int num : nums) {
            if ((num & 1) == 0) {
                result[even] = num;
                even += 2;
            } else {
                result[odd] = num;
                odd += 2;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] result = new SortArray().sortArrayByParityII(new int[] {4,2,5,7});
        Arrays.stream(result).forEach(x -> System.out.printf("%d ", x));
        System.out.println();
        int[] result2 = new SortArray().sortArrayByParityII(new int[] {2,3});
        Arrays.stream(result2).forEach(x -> System.out.printf("%d ", x));
        System.out.println();
    }
}

