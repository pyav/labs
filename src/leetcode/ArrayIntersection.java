/**
 * https://leetcode.com/problems/intersection-of-two-arrays/
 *
 * Output:
 * ------
 *
 */

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class ArrayIntersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for(int num : nums1) {
            set1.add(num);
        }
        for(int num : nums2) {
            set2.add(num);
        }
        set1.retainAll(set2);
        return set1.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] result = new ArrayIntersection().intersection(new int[]{1,2,2,1}, new int[]{2,2});
        java.util.Arrays.stream(result).forEach(x -> System.out.printf("%d ", x));
        System.out.println();
        int[] result2 = new ArrayIntersection().intersection(new int[]{4,9,5}, new int[]{9,4,9,8,4});
        java.util.Arrays.stream(result2).forEach(x -> System.out.printf("%d ", x));
        System.out.println();
        int[] result3 = new ArrayIntersection().intersection(new int[]{1,2,3}, new int[]{4,5,6});
        java.util.Arrays.stream(result3).forEach(x -> System.out.printf("%d ", x));
        System.out.println();
    }
}

