/**
 * https://leetcode.com/problems/third-maximum-number/
 *
 * Output:
 * ------
 * 1
 * 2
 * 1
 */

public class ThirdMax {
    public int thirdMax(int[] nums) {
        long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;

        for (int num : nums) {
            if (num == first || num == second || num == third) {
                continue;
            }
            if (num > first) {
                third = second;
                second = first;
                first = num;
            } else if (num > second) {
                third = second;
                second = num;
            } else if (num > third) {
                third = num;
            }
        }
        return (third == Long.MIN_VALUE)? (int) first: (int) third;
    }

    public static void main(String[] args) {
        System.out.println(new ThirdMax().thirdMax(new int[]{3,2,1}));
        System.out.println(new ThirdMax().thirdMax(new int[]{1,2}));
        System.out.println(new ThirdMax().thirdMax(new int[]{2,2,3,1}));
    }
}

