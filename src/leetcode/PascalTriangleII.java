/**
 * https://leetcode.com/problems/pascals-triangle-ii/
 *
 * Output:
 * ------
 * 1 7 21 35 35 21 7 1 
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class PascalTriangleII {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);

        if (1 == rowIndex) {
            list.add(1);
        } else if (rowIndex > 1) {
            list.add(1);
            rowIndex -= 2;
            while(rowIndex >= 0) {
                rowIndex--;
                int counter = 0;
                int listSize = list.size();
                int k = 0;
                for (int i = 0; i < listSize-1; i++) {
                    int a = list.get(k);
                    int b = list.get(k+1);
                    list.add(k+1, a+b);
                    if (1 == counter) {
                        list.remove(k);
                        k--;
                    } else {
                        counter++;
                    }
                    k += 2;
                }
            }
        }

        return list;
    }

    public static void main(String[] args) {
        List<Integer> result = new PascalTriangleII().getRow(7);
        for (Integer item : result) {
            System.out.printf("%d ", item);
        }
        System.out.println();
    }

}

