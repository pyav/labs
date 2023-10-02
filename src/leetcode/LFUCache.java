/**
 * https://leetcode.com/problems/lfu-cache/description/
 *
 * Output:
 * ------
 * 1
 * -1
 * 3
 * -1
 * 3
 * 4
 */

import java.util.*;

public class LFUCache {
    private int capacity;
    private Map<Integer, Integer> keyValueMap;
    private Map<Integer, Integer> keyCountMap;
    @SuppressWarnings("unchecked")
	private List<Integer>[] countKeysList = new ArrayList[100000];

    public LFUCache(int capacity) {
        this.capacity = capacity;
        keyValueMap = new HashMap<Integer, Integer>();
        keyCountMap = new HashMap<Integer, Integer>();
        for (int i = 0; i< 10000; i++) {
        	countKeysList[i] = new ArrayList<Integer>();
        }
    }

    public int get(int key) {
        int val = -1;
        if (keyValueMap.containsKey(key)) {
            val = keyValueMap.get(key);
            int count = keyCountMap.get(key);
    		countKeysList[count].remove(Integer.valueOf(key));
            count++;
            countKeysList[count].add(key);
            keyCountMap.put(key, count);
        }
        return val;
    }

    public void put(int key, int value) {
    	if (keyValueMap.containsKey(key)) {
    		keyValueMap.put(key, value);
    		int count = keyCountMap.get(key);
    		countKeysList[count].remove(Integer.valueOf(key));
    		count++;
    		keyCountMap.put(key, count);
    		countKeysList[count].add(key);
    	} else {
    		if (keyValueMap.size() < this.capacity) {
    			keyValueMap.put(key, value);
        		keyCountMap.put(key, 1);
        		countKeysList[1].add(key);
    		} else {
    			for (int i = 0; i < countKeysList.length; i++) {
            		if (countKeysList[i].size() > 0) {
            			int keyToRemove = countKeysList[i].remove(0);
            			keyValueMap.remove(keyToRemove);
            			keyCountMap.remove(keyToRemove);
            			break;
            		}
            	}
            	keyValueMap.put(key, value);
            	keyCountMap.put(key, 1);
            	countKeysList[1].add(key);
    		}
    	}
    }

    public static void main(String[] args) {
        LFUCache lfu = new LFUCache(2);
        lfu.put(1, 1);
        lfu.put(2, 2);
        System.out.println(lfu.get(1));
        lfu.put(3, 3);
        System.out.println(lfu.get(2));
        System.out.println(lfu.get(3));
        lfu.put(4, 4);
        System.out.println(lfu.get(1));
        System.out.println(lfu.get(3));
        System.out.println(lfu.get(4));
    }
}

