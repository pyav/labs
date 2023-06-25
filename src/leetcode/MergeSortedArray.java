/**
 * https://leetcode.com/problems/merge-sorted-array/
 *
 * Output:
 * ------
 * 1 2 2 3 5 6 
 * 1 
 * 1 
 * 1 2 3 4 5 6 
 * 1 2 3 4 5 6 
*/

import java.util.Arrays;

public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1, j = nums1.length-1;
        while(i >= 0) {
            nums1[j--] = nums1[i--];
        }
        if (n!=0) {
            i = j+1;
            j = 0;
            int curr = 0;
            while (m!=0 && i < nums1.length && j < nums2.length) {
                if (nums1[i] < nums2[j]) {
                    nums1[curr++] = nums1[i++];
                } else {
                    nums1[curr++] = nums2[j++];
                }
            }
            if (i == nums1.length) {
                while(j<nums2.length) {
                    nums1[curr++] = nums2[j++];
                }
            } else if (j == nums2.length) {
                while(i<nums1.length) {
                    nums1[curr++] = nums1[i++];
                }
            } else {
                while(j<nums2.length) {
                    nums1[curr++] = nums2[j++];
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        new MergeSortedArray().merge(nums1, 3, nums2, 3);
        Arrays.stream(nums1).forEach(x -> System.out.printf("%d ", x));
        System.out.println();
        int[] nums11 = {1};
        int[] nums22 = {};
        new MergeSortedArray().merge(nums11, 1, nums22, 0);
        Arrays.stream(nums11).forEach(x -> System.out.printf("%d ", x));
        System.out.println();
        int[] nums111 = {0};
        int[] nums222 = {1};
        new MergeSortedArray().merge(nums111, 0, nums222, 1);
        Arrays.stream(nums111).forEach(x -> System.out.printf("%d ", x));
        System.out.println();
        int[] nums1111 = {4,5,6,0,0,0};
        int[] nums2222 = {1,2,3};
        new MergeSortedArray().merge(nums1111, 3, nums2222, 3);
        Arrays.stream(nums1111).forEach(x -> System.out.printf("%d ", x));
        System.out.println();
        int[] nums11111 = {4,0,0,0,0,0};
        int[] nums22222 = {1,2,3,5,6};
        new MergeSortedArray().merge(nums11111, 1, nums22222, 5);
        Arrays.stream(nums11111).forEach(x -> System.out.printf("%d ", x));
        System.out.println();
    }

}

