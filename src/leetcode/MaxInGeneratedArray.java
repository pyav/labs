/**
 * https://leetcode.com/problems/get-maximum-in-generated-array/
 *
 * Output:
 * ------
 * 0
 * 21
 * 3
 * 1
 * 2
 */

public class MaxInGeneratedArray {

    public int getMaximumGenerated(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int[] result = new int[(n/2)+2];
        result[0] = 0;
        result[1] = 1;
        int max = result[0];
        for (int i = 2; i < result.length; i++) {
            if (i%2 == 0) {
                result[i] = result[i/2];
            } else {
                result[i] = result[i/2] + result[(i/2)+1];
            }
            if (max < result[i]) {
                max = result[i];
            }
        }
        for (int i = 2+(n/2); i <= n; i++) {
            int val;
            if (i%2 == 0) {
                val = result[i/2];
            } else {
                val = result[i/2] + result[(i/2)+1];
            }
            if (max < val) {
                max = val;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(new MaxInGeneratedArray().getMaximumGenerated(0));
        System.out.println(new MaxInGeneratedArray().getMaximumGenerated(100));
        System.out.println(new MaxInGeneratedArray().getMaximumGenerated(7));
        System.out.println(new MaxInGeneratedArray().getMaximumGenerated(2));
        System.out.println(new MaxInGeneratedArray().getMaximumGenerated(3));
    }

}

