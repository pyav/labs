/**
 * https://leetcode.com/problems/next-greater-element-ii/description/
 *
 * Output:
 * ------
 * 2 3 4 -1 4 
 * 2 -1 2 
 * -1 
 * 120 11 120 120 123 123 -1 100 100 100 
 * -1 -1 
 * -1 -1 
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NextGreaterElementII {
    
    private int[] getDoubleLenArr(int[] nums) {
        int[] newArr = new int[nums.length*2 - 1];
        for (int i = 0; i < nums.length; i++) {
            newArr[i] = nums[i];
        }
        for (int i = 0; i < nums.length-1; i++) {
            newArr[i + nums.length] = nums[i];
        }
        return newArr;
    }

    public int[] nextGreaterElement(int[] nums) {
    	int[] result = new int[nums.length];
        if (nums.length == 1) {
            result[0] = -1;
            return result;
        }
        int[] newArr = getDoubleLenArr(nums);
    	int[] v = new int[newArr.length];
    	v[v.length-1] = -1;
    	Map<Integer, Integer> idxMap = new HashMap<Integer, Integer>();
    	for (int i = 0; i < nums.length; i++) {
    		idxMap.put(nums[i], i);
    	}
    	int maxIdxSoFar = newArr.length - 1;
    	for (int i = newArr.length-2; i >= 0; i--) {
    		if (newArr[i+1] > newArr[i]) {
    			v[i] = newArr[i+1];
    		} else if (v[i+1] > newArr[i]) {
    			v[i] = v[i+1];
    		} else if (newArr[maxIdxSoFar] > newArr[i]) {
    			for (int j = i+1; j <= maxIdxSoFar; j++) {
    				if (newArr[j] > newArr[i]) {
    					v[i] = newArr[j];
    					break;
    				}
    			}
    		} else {
    			v[i] = -1;
    		}
            if (newArr[i] > newArr[maxIdxSoFar]) {
                maxIdxSoFar = i;
            }
    	}
    	for (int i = 0; i < nums.length; i++) {
    		result[i] = v[i];
    	}
    	return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,3};
        int[] result = new NextGreaterElementII().nextGreaterElement(nums);
        Arrays.stream(result).forEach(e -> System.out.printf("%d ", e));
        System.out.println();
        int[] nums2 = {1,2,1};
        int[] result2 = new NextGreaterElementII().nextGreaterElement(nums2);
        Arrays.stream(result2).forEach(e -> System.out.printf("%d ", e));
        System.out.println();
        int[] nums3 = {1};
        int[] result3 = new NextGreaterElementII().nextGreaterElement(nums3);
        Arrays.stream(result3).forEach(e -> System.out.printf("%d ", e));
        System.out.println();
        int[] nums4 = {100,1,11,1,120,111,123,1,-1,-100};
        int[] result4 = new NextGreaterElementII().nextGreaterElement(nums4);
        Arrays.stream(result4).forEach(e -> System.out.printf("%d ", e));
        System.out.println();
        int[] nums5 = {-2,-1};
        int[] result5 = new NextGreaterElementII().nextGreaterElement(nums5);
        Arrays.stream(result5).forEach(e -> System.out.printf("%d ", e));
        System.out.println();
        int[] nums6 = {-1,-2};
        int[] result6 = new NextGreaterElementII().nextGreaterElement(nums6);
        Arrays.stream(result6).forEach(e -> System.out.printf("%d ", e));
    }

}

