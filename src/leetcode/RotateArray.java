import java.util.Arrays;

/**
 * https://leetcode.com/problems/rotate-array/description/
 * 
 * Output:
 * ------
 * 5 6 7 1 2 3 4 
 */

public class RotateArray {
	
	private void reverse(int[] nums, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int mod = k%n;
        reverse(nums, 0, n-1);
        reverse(nums, 0, mod-1);
        reverse(nums, mod, n-1);
    }

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7};
		new RotateArray().rotate(nums, 3);
		Arrays.stream(nums).forEach(x -> System.out.printf("%d ", x));
		System.out.println();
	}

}
