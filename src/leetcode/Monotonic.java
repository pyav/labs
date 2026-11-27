/**
 * https://leetcode.com/problems/monotonic-array/
 *
 * Output:
 * ------
 * true
 * true
 * false
 * true
 */

public class Monotonic {
    private boolean reverseCalcPattern(int[] nums) {
        for (int i = nums.length-1; i > 0; i--) {
            if (nums[i] - nums[i-1] > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean calcPattern(int[] nums) {
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i+1] - nums[i] < 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isMonotonic(int[] nums) {
        return calcPattern(nums) || reverseCalcPattern(nums);
    }

    public static void main(String[] args) {
        System.out.println(new Monotonic().isMonotonic(new int[]{1,2,2,3}));
        System.out.println(new Monotonic().isMonotonic(new int[]{6,5,4,4}));
        System.out.println(new Monotonic().isMonotonic(new int[]{1,3,2}));
        System.out.println(new Monotonic().isMonotonic(new int[]{1,1,0}));
    }
}

