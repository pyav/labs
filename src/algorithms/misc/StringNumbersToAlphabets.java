/**
 * Given a string of numbers, convert to all possibilities of string of
 * alphabets.
 *
 * Output:
 * ------
 * ABC
 * AW
 * LC
 * ABCD
 * AWD
 * LCD
 */

import java.util.ArrayList;
import java.util.List;

public class StringNumbersToAlphabets {

    private List<String> result = new ArrayList<String>();

    private void calcStrVals(String init, String input) {
        if (null == input) {
            return;
        }
        if (0 == input.length()) {
            String[] arr = init.trim().split(" ");
            String item = "";
            boolean add = true;
            for (int i = 0; i < arr.length; i++) {
                if (Integer.valueOf(arr[i]) > 26 || Integer.valueOf(arr[i]) < 1) {
                    add = false;
                    break;
                }
                char t = (char) ('A' + Integer.valueOf(arr[i]) - 1);
                item += t;
            }
            if (add) {
                result.add(item);
            }
        }
        for (int i = 0; i < 2; i++) {
            if (i+1 > input.length()) {
                continue;
            }
            calcStrVals(init + " " + input.substring(0, i+1), input.substring(i+1, input.length()));
        }
    }

    public List<String> getStringValues(String str) {
        calcStrVals("", str);
        return result;
    }

    public static void main(String[] args) {
        List<String> result = new StringNumbersToAlphabets().getStringValues("123");
        for(String val : result) {
            System.out.println(val);
        }
        List<String> result2 = new StringNumbersToAlphabets().getStringValues("1234");
        for(String val : result2) {
            System.out.println(val);
        }
    }

}

