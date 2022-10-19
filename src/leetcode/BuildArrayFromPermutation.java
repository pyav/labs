/**
 * https://leetcode.com/problems/build-array-from-permutation/
 *
 * Output:
 * ------
 * 0 1 2 4 5 3 
 * 4 5 0 1 2 3
 */

public class  BuildArrayFromPermutation {
    
    public int[] buildArray(int[] nums) {
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[nums[i]];
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] nums = {0,2,1,5,3,4};
        int[] result = new BuildArrayFromPermutation().buildArray(nums);
        for (int i = 0 ; i < result.length; i++) {
            System.out.printf("%d ", result[i]);
        }
        System.out.println();
        int[] nums2 = {5,0,1,2,3,4};
        int[] result2 = new BuildArrayFromPermutation().buildArray(nums2);
        for (int i = 0 ; i < result2.length; i++) {
            System.out.printf("%d ", result2[i]);
        }
        System.out.println();
    }

}

