/**
 * Output:
 * ------
 * 3
 * 6
 * 7
 */

package pramp;

import java.io.*;
import java.util.*;

public class FindTheDuplicates {

    static int[] findDuplicates(int[] arr1, int[] arr2) {
        // N*log(M)
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < arr1.length; i++) {
            int k = arr1[i];
            int start = 0;
            int end = arr2.length - 1;

            while (start <= end) {
                int mid = (start + end) / 2;
                if (k < arr2[mid]) {
                    end = mid - 1;
                } else if (k > arr2[mid]) {
                    start = mid + 1;
                } else {
                    result.add(k);
                    break;
                }
            }
        }

        int[] resArr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resArr[i] = result.get(i);
        }

        return resArr;
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 3, 5, 6, 7 };
        int[] arr2 = { 3, 6, 7, 8, 20 };
        int[] result = FindTheDuplicates.findDuplicates(arr1, arr2);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

}
