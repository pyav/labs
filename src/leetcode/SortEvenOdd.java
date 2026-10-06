/**
 * https://leetcode.com/problems/sort-even-and-odd-indices-independently/description/
 *
 * Output:
 * ------
 * 2 3 4 1
 * 2 1
 * 1 10 3 8 5 6 7 4 9 2
 * 9 46 15 45 15 41 27 34 32 31 33 31 36 26 36 16 44 6
 * 15 45 32 31 36
 */

import java.util.Arrays;

public class SortEvenOdd {
    public int[] sortEvenOdd(int[] nums) {
        int[] odd = new int[nums.length/2];
        int[] even = new int[(nums.length+1)/2];
        int j = 0, k = 0;

        for (int i = 0; i < nums.length; i++) {
            if ((i & 1) == 0) {
                even[j++] = nums[i];
            } else {
                odd[k++] = nums[i];
            }
        }
        Arrays.sort(even);
        Arrays.sort(odd);
        int i = 0;
        for (int num : even) {
            nums[i] = num;
            i += 2;
        }
        i = 1;
        for (j = odd.length-1; j >= 0; j--) {
            nums[i] = odd[j];
            i += 2;
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] result = new SortEvenOdd().sortEvenOdd(new int[] {4,1,2,3});
        Arrays.stream(result).forEach(x -> System.out.printf("%d ", x));
        System.out.println();
        int[] result2 = new SortEvenOdd().sortEvenOdd(new int[] {2,1});
        Arrays.stream(result2).forEach(x -> System.out.printf("%d ", x));
        System.out.println();
        int[] result3 = new SortEvenOdd().sortEvenOdd(new int[] {1,2,3,4,5,6,7,8,9,10});
        Arrays.stream(result3).forEach(x -> System.out.printf("%d ", x));
        System.out.println();
        int[] result4 = new SortEvenOdd().sortEvenOdd(new int[] {36,45,32,31,15,41,9,46,36,6,15,16,33,26,27,31,44,34});
        Arrays.stream(result4).forEach(x -> System.out.printf("%d ", x));
        System.out.println();
        int[] result5 = new SortEvenOdd().sortEvenOdd(new int[] {36,45,32,31,15});
        Arrays.stream(result5).forEach(x -> System.out.printf("%d ", x));
        System.out.println();
    }
}

