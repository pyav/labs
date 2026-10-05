/**
 * https://leetcode.com/problems/sort-array-by-parity/
 *
 * Output:
 * ------
 * 2 4 1 3 
 * 0
 */

import java.util.Arrays;

public class SortArrayByParity {
    public int[] sortArrayByParity(int[] nums) {
        int even = 0, odd = nums.length-1;
        int[] result = new int[nums.length];
        for (int num : nums) {
            if ((num & 1) == 0) {
                result[even++] = num;
            } else {
                result[odd--] = num;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] result = new SortArrayByParity().sortArrayByParity(new int[] {3,1,2,4});
        Arrays.stream(result).forEach(x -> System.out.printf("%d ", x));
        System.out.println();
        int[] result2 = new SortArrayByParity().sortArrayByParity(new int[] {0});
        Arrays.stream(result2).forEach(x -> System.out.printf("%d ", x));
        System.out.println();
    }
}

