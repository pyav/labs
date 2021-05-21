/**
 * https://leetcode.com/problems/squares-of-a-sorted-array/
 *
 * Output:
 * ------
 * 0 1 1 4 4
 */

package leetcode;

public class SortedSqArr {

    public int[] sortedSquares(int[] nums) {
        int[] arrFinal = new int[nums.length];
        int idxReversal = -1;
        boolean isAllNegative = true;

        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] < 0) {
                nums[i] = nums[i] * -1;
            } else {
                isAllNegative = false;
            }
            if (nums[i] < nums[i+1]) {
                idxReversal = i;
                break;
            }
        }
        if (-1 == idxReversal) {
            if (isAllNegative) {
                for (int i = nums.length-1; i>=0; i--) {
                    arrFinal[nums.length - i - 1] = nums[i] * nums[i];
                }
            } else {
                for (int i = 0; i < nums.length; i++) {
                    arrFinal[i] = nums[i] * nums[i];
                }
            }
        } else {
            int i = idxReversal + 1;
            int j = idxReversal - 1;
            arrFinal[0] = nums[idxReversal] * nums[idxReversal];
            int k = 1;
            for (; i < nums.length && j >= 0;) {
                if (nums[i]  < nums[j]) {
                    arrFinal[k] = nums[i] * nums[i];
                    k++;
                    i++;
                } else {
                    arrFinal[k] = nums[j] * nums[j];
                    k++;
                    j--;
                }
            }
            while (i < nums.length) {
                arrFinal[k] = nums[i] * nums[i];
                i++;
                k++;
            }
            while (j >= 0) {
                arrFinal[k] = nums[j] * nums[j];
                j--;
                k++;
            }
        }

        return arrFinal;
    }

    public static void main(String[] args) {
        int[] arr = {-2, -1, 0, 1, 2};
        //int[] arr = {0, 1, 3, 4, 5};
        //int[] arr = {-4, -3, -2, -1};
        //int[] arr = {-3, 0, 2};
        int [] arrFinal = new SortedSqArr().sortedSquares(arr);
        for (int i = 0; i <arrFinal.length; i++) {
            System.out.printf("%d ", arrFinal[i]);
        }
    }
}
