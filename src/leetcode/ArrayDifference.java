/**
 * https://leetcode.com/problems/find-the-difference-of-two-arrays/
 *
 * Output:
 * ------
 * [1, 3]
 * [4, 6]
 * [3]
 * []
 */

import java.util.*;

public class ArrayDifference {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }

        Set<Integer> set2 = new HashSet<>();
        for (int num : nums2) {
            set2.add(num);
        }

        Set<Integer> set3 = new HashSet<>();
        set3.addAll(set1);
        set1.removeAll(set2);
        set2.removeAll(set3);

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>(set1);
        List<Integer> list2 = new ArrayList<>(set2);
        result.add(list1);
        result.add(list2);

        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayDifference().findDifference(new int[] {1,2,3}, new int[] {2,4,6});
        result.stream().forEach(x -> System.out.println(x.toString()));
        List<List<Integer>> result2 = new ArrayDifference().findDifference(new int[] {1,2,3,3}, new int[] {1,1,2,2});
        result2.stream().forEach(x -> System.out.println(x.toString()));
    }
}

