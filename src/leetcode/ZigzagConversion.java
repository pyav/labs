/**
 * https://leetcode.com/problems/zigzag-conversion/
 *
 * Output:
 * ------
 * PAHNAPLSIIGYIR
 * PINALSIGYAHRPI
 * A
 * AB
 */

import java.util.Arrays;

public class ZigzagConversion {

    public String convert(String s, int numRows) {
        String[] result = new String[numRows];

        if (numRows == 1) {
            return s;
        }
        for (int i = 0; i < numRows && i < s.length(); i++) {
            result[i] = String.valueOf(s.charAt(i));
        }
        boolean fwd = false;
        int count = 0, i = 0;
        for (i  = numRows; i < s.length(); i++, count++) {
            if (count == numRows-1) {
                fwd ^= true;
                count = 0;
            }
            if (fwd) {
                result[count+1] = result[count+1] + s.charAt(i);
            } else {
                result[(numRows-1) - (count+1)] = result[(numRows-1) - (count+1)] + s.charAt(i);
            }
        }
        String resultStr = new String();
        for (i = 0; i < result.length; i++) {
            if (result[i] == null) continue;
            resultStr += result[i];
        }
        return resultStr;
    }

    public static void main(String[] args) {
        System.out.println(new ZigzagConversion().convert("PAYPALISHIRING", 3));
        System.out.println(new ZigzagConversion().convert("PAYPALISHIRING", 4));
        System.out.println(new ZigzagConversion().convert("A", 1));
        System.out.println(new ZigzagConversion().convert("AB", 1));
    }

}

