/**
 * https://leetcode.com/problems/product-of-array-except-self/
 *
 * Output:
 * ------
 * 24 12 8 6 
 * 0 0 9 0 0 
 */

public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prod = new int[n];
        prod[n-1] = nums[n-1];

        for (int i = n-2; i > 0; i--) {
            prod[i] = prod[i+1] * nums[i];
        }

        int preMult = 1;
        int[] result = new int[n];
        for (int i = 0; i < n-1; i++) {
            if (0 == i) {
                result[i] = prod[i+1];
                preMult *= nums[i];
                continue;
            }
            result[i] = preMult * prod[i+1];
            preMult *= nums[i];
        }
        result[n-1] = preMult;

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] result = new ProductOfArrayExceptSelf().productExceptSelf(nums);
        for (int i : result) {
            System.out.printf("%d ", i);
        }
        System.out.println();
        int[] nums2 = {-1,1,0,-3,3};
        int[] result2 = new ProductOfArrayExceptSelf().productExceptSelf(nums2);
        for (int i : result2) {
            System.out.printf("%d ", i);
        }
        System.out.println();
    }

}

