/**
 * Following program demonstrates the usage of LinkedHashMap.
 * 
 * Output
 * ------
 * 
 * Key: Key1, Value: Value1
 * Key: Key1, Value: Value1
 * Key: Key2, Value: Value2
 * 
 * 
 * @author pyav
 *
 */

import java.util.LinkedHashMap;

public class LinkedHashMapExample {

    public static void main(String[] args) {
	LinkedHashMap<String, String> list = new LinkedHashMap<String, String>();
	list.put("Key1", "Value1");
	list.put("Key2", "Value2");

	String firstKey = list.keySet().iterator().next();
	System.out.println("Key: " + firstKey + ", Value: " + list.get(firstKey));

	for (String temp : list.keySet()) {
	    System.out.println("Key: " + temp + ", Value: " + list.get(temp));
	}
    }

}
