/**
 * https://leetcode.com/problems/baseball-game/description/
 *
 * Output:
 * ------
 * 30
 * 27
 * 0
 */

import java.util.List;
import java.util.ArrayList;

public class BaseballGame {

    public int calPoints(String[] operations) {
    	List<Integer> list = new ArrayList<Integer>();
    	for (int i = 0; i < operations.length; i++) {
    		if (operations[i].equals("C")) {
    			list.remove(list.size()-1);
    		} else if (operations[i].equals("D")) {
    			list.add(list.get(list.size()-1)*2);
    		} else if (operations[i].equals("+")) {
    			list.add(list.get(list.size()-1) + list.get(list.size()-2));
    		} else {
    			list.add(Integer.valueOf(operations[i]));
    		}
    	}
    	return list.stream().mapToInt(Integer::intValue).sum();
    }

    public static void main(String[] args) {
        String[] operations1 = {"5","2","C","D","+"};
        System.out.println(new BaseballGame().calPoints(operations1));
        String[] operations2 = {"5","-2","4","C","D","9","+","+"};
        System.out.println(new BaseballGame().calPoints(operations2));
        String[] operations3 = {"1", "C"};
        System.out.println(new BaseballGame().calPoints(operations3));
    }

}

