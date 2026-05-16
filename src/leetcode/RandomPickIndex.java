/**
 * https://leetcode.com/problems/random-pick-index/
 *
 * Output:
 * ------
 * 4
 * 0
 * 2
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomPickIndex {

    private Map<Integer, List<Integer>> map = null;
    private Random rand = null;

    public RandomPickIndex(int[] nums) {
        map = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = map.getOrDefault(nums[i], new ArrayList<Integer>());
            list.add(i);
            map.put(nums[i], list);
        }
        rand = new Random();
    }

    public int pick(int target) {
        List<Integer> list = map.get(target);
        int n = list.size();
        int randomVal = rand.nextInt(n);
        return list.get(randomVal);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 3};
        RandomPickIndex obj = new RandomPickIndex(nums);
        System.out.println(obj.pick(3));
        System.out.println(obj.pick(1));
        System.out.println(obj.pick(3));
    }
}

