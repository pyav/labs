/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
 *
 * Output:
 * ------
 * 1 2
 * 1 3
 * 1 2
 */

public class TwoSumII {

    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        for (int i = 0, j = numbers.length-1; i < j;) {
            if (numbers[i] + numbers[j] == target) {
                result[0] = i+1;
                result[1] = j+1;
                break;
            } else if (numbers[i] + numbers[j] > target) {
                j--;
            } else if (numbers[i] + numbers[j] < target) {
                i++;
            }
        }
        return result;
    }

    public static void main(String[] args ) {
        int[] result1 = new TwoSumII().twoSum(new int[]{2,7,11,15}, 9);
        System.out.printf("%d %d\n", result1[0], result1[1]);
        int[] result2 = new TwoSumII().twoSum(new int[]{2,3,4}, 6);
        System.out.printf("%d %d\n", result2[0], result2[1]);
        int[] result3 = new TwoSumII().twoSum(new int[]{-1,0}, -1);
        System.out.printf("%d %d\n", result3[0], result3[1]);
    }

}

