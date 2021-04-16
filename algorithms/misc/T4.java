/**
 * Output:
 * ------
 * 1
 * 2
 */

package tests;

import java.util.*;
import java.util.Map.Entry;

public class T4 {

	public static List<String> processLogs(List<String> logs, int threshold) {
		Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();

		for (String log : logs) {
			String[] arr = log.split(" ");
			int key1 = Integer.valueOf(arr[0]);
			int key2 = Integer.valueOf(arr[1]);

			if (key1 == key2) {
				if (countMap.containsKey(key1)) {
					int val = countMap.get(key1);
					countMap.put(key1, val + 1);
				} else {
					countMap.put(key1, 1);
				}
			} else {
				if (countMap.containsKey(key1)) {
					int val1 = countMap.get(key1);
					countMap.put(key1, val1 + 1);
				} else {
					countMap.put(key1, 1);
				}
				if (countMap.containsKey(key2)) {
					int val2 = countMap.get(key2);
					countMap.put(key2, val2 + 1);
				} else {
					countMap.put(key2, 1);
				}

			}
		}

		List<Integer> intList = new ArrayList<Integer>();
		for (Entry<Integer, Integer> entry : countMap.entrySet()) {
			if (entry.getValue() >= threshold) {
				intList.add(entry.getKey());
			}
		}
		intList.sort(null);

		List<String> ids = new ArrayList<String>();
		for (int i : intList) {
			ids.add(String.valueOf(i));
		}

		return ids;
	}

	public static void main(String[] args) {
		List<String> str = new ArrayList<String> ();
		str.add("1 2 50");
		str.add("1 7 70");
		str.add("1 3 20");
		str.add("2 2 17");
		
		List<String> result = T4.processLogs(str, 2);
		for (String val: result) {
			System.out.println(val);
		}
	}

}
