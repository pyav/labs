/**
 * https://leetcode.com/problems/kth-missing-positive-number/
 *
 * Output:
 * ------
 * 9
 * 6
 * 1
 */

public class KthMissing {
    public int findKthPositive(int[] arr, int k) {
        int m = 0, i = 0;
        for (; i < arr.length; i++) {
            if (arr[i] - m - 1 < k) {
                k -= arr[i] - m - 1;
            } else {
                return m + k;
            }
            m = arr[i];
        }
        return m + k;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,4,7,11};
        System.out.println(new KthMissing().findKthPositive(arr, 5));
        int[] arr2 = {1,2,3,4};
        System.out.println(new KthMissing().findKthPositive(arr2, 2));
        int[] arr3 = {2};
        System.out.println(new KthMissing().findKthPositive(arr3, 1));
    }
}

