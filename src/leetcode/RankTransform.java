/**
 * https://leetcode.com/problems/rank-transform-of-an-array/
 *
 * Output:
 * ------
 * 4 1 2 3 
 * 1 1 1 
 * 5 3 4 2 8 6 7 1 3 
 * 
 */

import java.util.*;

public class RankTransform {
    public static int[] arrayRankTransform(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            List<Integer> list = map.getOrDefault(arr[i], new ArrayList<>());
            list.add(i);
            map.put(arr[i], list);
        }
        Arrays.sort(arr);
        int[] result = new int[n];
        int rank = 1;
        for (int num : arr) {
            if (!map.containsKey(num)) {
                continue;
            }
            List<Integer> list = map.get(num);
            map.remove(num);
            for (int idx : list) {
                result[idx] = rank;
            }
            rank++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] result = arrayRankTransform(new int[]{40, 10, 20, 30});
        Arrays.stream(result).forEach(x -> System.out.printf("%d ", x));
        System.out.println();
        int[] result2 = arrayRankTransform(new int[]{100,100,100});
        Arrays.stream(result2).forEach(x -> System.out.printf("%d ", x));
        System.out.println();
        int[] result3 = arrayRankTransform(new int[]{37,12,28,9,100,56,80,5,12});
        Arrays.stream(result3).forEach(x -> System.out.printf("%d ", x));
        System.out.println();
        int[] result4 = arrayRankTransform(new int[]{});
        Arrays.stream(result4).forEach(x -> System.out.printf("%d ", x));
        System.out.println();
    }
}
