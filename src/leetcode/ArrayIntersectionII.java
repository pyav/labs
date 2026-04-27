/**
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/
 * 
 *  Output:
 *  ------
 *  4 9
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class ArrayIntersectionII {
	
	public int[] intersect(int[] nums1, int[] nums2) {
        int[] count1 = new int[1001];
        Arrays.fill(count1, 0);
        int[] count2 = new int[1001];
        Arrays.fill(count2, 0);
        
        for (int i = 0; i < nums1.length; i++) {
        	count1[nums1[i]]++;
        }
        for (int i = 0; i < nums2.length; i++) {
        	count2[nums2[i]]++;
        }
        
        for (int i = 0; i < count1.length; i++) {
        	count1[i] = Math.min(count1[i], count2[i]);
        }
        
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < count1.length; i++) {
        	for (int j = 0; j < count1[i]; j++) {
        		result.add(i);
        	}
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

	public static void main(String[] args) {
		int[] nums1 = {4,9,5};
		int[] nums2 = {9,4,9,8,4};
		int[] result = new ArrayIntersectionII().intersect(nums1, nums2);
		Arrays.stream(result).forEach(x -> System.out.printf("%d ", x));
		System.out.println();
	}

}
