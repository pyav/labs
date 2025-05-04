/**
 * Print permutations of a string
 *
 * Otuput:
 * ------
 *
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class StringPermutation {

    static void swap(StringBuilder strBldr, int i, int j) {
        char temp = strBldr.charAt(i);
        strBldr.setCharAt(i, strBldr.charAt(j));
        strBldr.setCharAt(j, temp);
    }

    static void calcPermutations(int idx, StringBuilder strBldr, List<String> result) {
        if(idx == strBldr.length()) {
            result.add(strBldr.toString());
            return;
        }
        for (int i = idx; i < strBldr.length(); i++) {
            swap(strBldr, idx, i);
            calcPermutations(idx+1, strBldr, result);
            swap(strBldr, idx, i);
        }
    }

    static List<String> findPermutation(String s) {
        List<String> result = new ArrayList<String>();
        StringBuilder strBldr = new StringBuilder(s);
        calcPermutations(0, strBldr, result);
        Collections.sort(result);
        return result;
    }

    public static void main(String[] args) {
        String s = "ABC";
        List<String> result = findPermutation(s);
        result.stream().forEach(System.out::println);
    }
}

