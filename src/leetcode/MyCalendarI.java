/**
 * https://leetcode.com/problems/my-calendar-i/
 *
 * Output:
 * ------
 * true
 * false
 * true
 * false
 * true
 * true
 */

import java.util.Map.Entry;
import java.util.*;

public class MyCalendarI {
	
	private NavigableMap<Integer, Integer> map = null;
    
    public MyCalendarI() {
    	map = new TreeMap<>();
    }

    public boolean book(int startTime, int endTime) {    	
    	Entry<Integer, Integer> floorEntry = map.floorEntry(startTime);
    	Entry<Integer, Integer> ceilingEntry = map.ceilingEntry(startTime);
    	
    	if (null == floorEntry && null == ceilingEntry) {
    		map.put(startTime, endTime);
    		return true;
    	}
    	
    	if (null != floorEntry && endTime > floorEntry.getKey() && startTime < floorEntry.getValue()) {
    		return false;
    	}
    	if (null != ceilingEntry && endTime > ceilingEntry.getKey() && startTime < ceilingEntry.getValue()) {
    		return false;
    	}
    	
    	map.put(startTime, endTime);
    	return true;
    }

    public static void main(String[] args) {
        MyCalendarI obj = new MyCalendarI();
        System.out.println(obj.book(10,20));
        System.out.println(obj.book(15,25));
        System.out.println(obj.book(20,30));
        System.out.println(obj.book(20,30));
        System.out.println(obj.book(30,32));
        System.out.println(obj.book(32,40));
    }
}

