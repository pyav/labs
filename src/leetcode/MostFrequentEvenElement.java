/**
 * https://leetcode.com/problems/most-frequent-even-element/description/
 *
 * Otuput:
 * ------
 * 2
 * -1
 * 3346
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MostFrequentEvenElement {

    public int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> mapCount = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] %2 == 0) {
                mapCount.put(nums[i], mapCount.getOrDefault(nums[i], 0)+1);
            }
        }
        int max = Integer.MIN_VALUE;
        int maxElem = -1;
        for (Entry<Integer, Integer> entry : mapCount.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                maxElem = entry.getKey();
            } else if (entry.getValue() == max) {
                if (entry.getKey() < maxElem) {
                    max = entry.getValue();
                    maxElem = entry.getKey();
                }
            }
        }
        return maxElem;
    }

    public static void main(String[] args) {
        System.out.println(new MostFrequentEvenElement().mostFrequentEven(new int[] {0,1,2,2,4,4,1}));
        System.out.println(new MostFrequentEvenElement().mostFrequentEven(new int[] {29,47,21,41,13,37,25,7}));
        System.out.println(new MostFrequentEvenElement().mostFrequentEven(new int[] {8154,9139,8194,3346,5450,9190,133,8239,4606,8671,8412,6290}));
    }

}

