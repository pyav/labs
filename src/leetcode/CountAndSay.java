/**
 * https://leetcode.com/problems/count-and-say/description/
 *
 * Output:
 * ------
 * 1
 * 11
 * 21
 * 1211
 * 111221
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class CountAndSay {
    public String countAndSay(int n) {
        List<String> list = new ArrayList<String>();
        list.add("1");

        for (int i = 2; i <= n; i++) {
        	List<String> newList = new ArrayList<String>();
        	
        	String val = list.get(0);
            int count = 1;
            
            for (int j = 1; j < list.size(); j++) {
                String valNext = list.get(j);
                if (valNext.equals(val)) {
                	count++;
                } else {
                	newList.add(String.valueOf(count));
                	newList.add(String.valueOf(val));
                	val = list.get(j);
                	count = 1;
                }
            }
            newList.add(String.valueOf(count));
            newList.add(String.valueOf(val));
            list = newList;
        }

        return list.stream().collect(Collectors.joining(""));
    }

    public static void main(String[] args) {
        System.out.println(new CountAndSay().countAndSay(1));
        System.out.println(new CountAndSay().countAndSay(2));
        System.out.println(new CountAndSay().countAndSay(3));
        System.out.println(new CountAndSay().countAndSay(4));
        System.out.println(new CountAndSay().countAndSay(5));
    }
}
