/**
 * https://leetcode.com/problems/design-hashset/description/
 *
 * Output:
 * ------
 * true
 * false
 * true
 * false
 */

import java.util.Arrays;

public class DesignHashSet {

    boolean[] set;

    public DesignHashSet() {
        set = new boolean[1000001];
        //Arrays.fill(set, false);
    }

    public void add(int key) {
        set[key] = true;
    }

    public void remove(int key) {
        set[key] = false;
    }

    public boolean contains(int key) {
        return set[key];
    }
    
    public static void main(String[] args) {
        DesignHashSet obj = new DesignHashSet();
        obj.add(1);
        obj.add(2);
        System.out.println(obj.contains(1));
        System.out.println(obj.contains(3));
        obj.add(2);
        System.out.println(obj.contains(2));
        obj.remove(2);
        System.out.println(obj.contains(2));
    }

}

