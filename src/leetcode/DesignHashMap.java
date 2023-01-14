/**
 * https://leetcode.com/problems/design-hashmap/
 *
 * Output:
 * ------
 * 1
 * -1
 * 1
 * -1
 */

import java.util.Arrays;

public class DesignHashMap {

    int[] map;

    public DesignHashMap() {
        map = new int[1000001];
        Arrays.fill(map, -1);
    }

    public void put(int key, int value) {
        map[key] = value;
    }

    public int get(int key) {
        return map[key];
    }

    public void remove(int key) {
        map[key] = -1;
    }

    public static void main(String[] args) {
        DesignHashMap obj = new DesignHashMap();
        obj.put(1, 1);
        obj.put(2, 2);
        System.out.println(obj.get(1));
        System.out.println(obj.get(3));
        obj.put(2, 1);
        System.out.println(obj.get(2));
        obj.remove(2);
        System.out.println(obj.get(2));
    }

}

