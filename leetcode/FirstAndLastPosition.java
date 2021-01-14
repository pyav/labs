/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 *
 * Output:
 * ------
 * 0 0
 */

package leetcode;

public class FirstAndLastPosition {
    public int[] searchRange(int[] nums, int target) {
        int first = 0;
        int last = nums.length-1;
        int mid = (first+last)/2;
        int found = 0;
        int result[] = {-1,-1};

        if (nums.length == 0) {
            return result;
        }

        boolean foundFirst = false;
        boolean foundSecond = false;
        while (first <= last && found < 2) {
            if (first == last) {
                if (nums[first] == target) {
                    int[] tmp = {first, first};
                    return tmp;
                } else {
                    int[] def = {-1, -1};
                    return def;
                }
            }

            if (nums[first] == target && !foundFirst) {
                result[0] = first;
                found++;
                foundFirst = true;
            }
            if (nums[last] == target && !foundSecond) {
                result[1] = last;
                found++;
                foundSecond = true;
            }
            if (!foundFirst) {
                first++;
            }
            if (!foundSecond) {
                last--;
            }
        }
        
        if (found == 2) {
            return result;
        } else {
            int[] def = {-1, -1};
            return def;
        }
    }

    public static void main(String[] args) {
        //int [] nums = {5,7,7,8,8,10};
        int [] nums = {1};
        //int [] nums = {8,7};
        int[] result = new FirstAndLastPosition().searchRange(nums, 1);
        System.out.printf("%d %d", result[0], result[1]);
    }
}
