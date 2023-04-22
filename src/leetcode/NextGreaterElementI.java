/**
 * https://leetcode.com/problems/next-greater-element-i/description/
 *
 * Output:
 * ------
 * -1 3 -1 
 */

import java.util.HashMap;
import java.util.Map;

public class NextGreaterElementI {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    	int[] result = new int[nums1.length];
    	int[] v = new int[nums2.length];
    	v[v.length-1] = -1;
    	Map<Integer, Integer> idxMap = new HashMap<Integer, Integer>();
    	for (int i = 0; i < nums2.length; i++) {
    		idxMap.put(nums2[i], i);
    	}
    	int maxIdxSoFar = nums2.length - 1;
    	for (int i = nums2.length-2; i >= 0; i--) {
    		if (nums2[i+1] > nums2[i]) {
    			v[i] = nums2[i+1];
    		} else if (v[i+1] > nums2[i]) {
    			v[i] = v[i+1];
    		} else if (nums2[maxIdxSoFar] > nums2[i]) {
    			for (int j = i+1; j <= maxIdxSoFar; j++) {
    				if (nums2[j] > nums2[i]) {
    					v[i] = nums2[j];
    					break;
    				}
    			}
    		} else {
    			v[i] = -1;
    		}
            if (nums2[i] > nums2[maxIdxSoFar]) {
                maxIdxSoFar = i;
            }
    	}
    	for (int i = 0; i < nums1.length; i++) {
    		result[i] = v[idxMap.get(nums1[i])];
    	}
    	return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        int[] result = new NextGreaterElementI().nextGreaterElement(nums1, nums2);
        for (int i = 0; i < result.length; i++) {
        	System.out.printf("%d ", result[i]);
        }
    }
}

