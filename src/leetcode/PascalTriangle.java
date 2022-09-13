/**
 * https://leetcode.com/problems/pascals-triangle/
 *
 * Output:
 * ------
 * 1 
 * 1 1 
 * 1 2 1 
 * 1 3 3 1 
 * 1 4 6 4 1 
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class PascalTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        result.add(list);

        if (2 == numRows) {
            List<Integer> list2 = new ArrayList<Integer>();
            list2.add(1);
            list2.add(1);
            result.add(list2);
        } else if (numRows > 2) {
            numRows -= 2;
            while(numRows >= 0) {
                List<Integer> lastList = result.get(result.size()-1);
                List<Integer> nextList = new ArrayList<Integer>();

                for (int i = 0; i <= lastList.size(); i++) {
                    if (0 == i) {
                        nextList.add(lastList.get(i));
                    } else if (lastList.size() == i) {
                        nextList.add(lastList.get(i-1));
                    } else {
                        nextList.add(lastList.get(i-1) + lastList.get(i));
                    }
                }
                if (nextList.size() > 0) {
                    result.add(nextList);
                }
                numRows--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = new PascalTriangle().generate(5);
        for (List<Integer> list : result) {
            for (Integer item : list) {
                System.out.printf("%d ", item);
            }
            System.out.println();
        }
    }

}

