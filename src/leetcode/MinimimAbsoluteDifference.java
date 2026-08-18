/**
 * https://leetcode.com/problems/minimum-absolute-difference/description/
 *
 * Output:
 * ------
 * 1 2 2 3 3 4 
 * 1 3
 */

import java.util.*;

public class MinimimAbsoluteDifference {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int minDiff = Math.abs(arr[1] - arr[0]);
        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < n-1; i++) {
            if (minDiff < Math.abs(arr[i+1] - arr[i])) {
                continue;
            } else if (minDiff > Math.abs(arr[i+1] - arr[i])) {
                result.clear();
                minDiff = Math.abs(arr[i+1] - arr[i]);
            }
            List<Integer> list = new ArrayList<>();
            list.add(arr[i]);
            list.add(arr[i+1]);
            result.add(list);
        }

        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = new MinimimAbsoluteDifference().minimumAbsDifference(new int[] {4,2,1,3});
        for(List<Integer> list : result) {
            list.stream().forEach(x -> System.out.printf("%d ", x));
        }
        System.out.println();
        List<List<Integer>> result2 = new MinimimAbsoluteDifference().minimumAbsDifference(new int[] {1,3,6,10,15});
        for(List<Integer> list : result2) {
            list.stream().forEach(x -> System.out.printf("%d ", x));
        }
        System.out.println();
    }
}

