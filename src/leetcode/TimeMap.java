/**
 * https://leetcode.com/problems/time-based-key-value-store/description/
 *
 * Output:
 * ------
 * bar
 * bar
 * bar2
 * bar2
 * bar
 */

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeMap {
    private Map<String, TreeMap<Integer, String>> map = null;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> treeMap = map.getOrDefault(key, new TreeMap<>());
        treeMap.put(timestamp, value);
        map.put(key, treeMap);
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        TreeMap<Integer, String> _map = map.get(key);
        Integer val = _map.floorKey(timestamp);
        if (null == val) {
            return "";
        }
        return _map.get(val);
    }

    public static void main(String[] args) {
        TimeMap obj = new TimeMap();
        obj.set("foo", "bar", 1);
        System.out.println(obj.get("foo", 1));
        System.out.println(obj.get("foo", 3));
        obj.set("foo", "bar2", 4);
        System.out.println(obj.get("foo", 4));
        System.out.println(obj.get("foo", 5));
        System.out.println(obj.get("foo", 3));
    }
}

