/**
 * https://leetcode.com/problems/lru-cache/description/
 *
 * Output:
 * ------
 * 1
 * -1
 * -1
 * 3
 * 4
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LRUCache {
	class Node {
		int key;
		int val;
		public Node(int _key, int _val) {
			key = _key;
			val = _val;
		}
	}
	private final int capacity;
	private Map<Integer, Node> map;
	private List<Node> list;

	public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<Integer, Node>();
        list = new ArrayList<Node>();
    }
    
    public int get(int key) {
    	int val = -1;
    	if (map.containsKey(key)) {
    		Node node = map.get(key);
    		val = node.val;
    		list.remove(node);
    		list.add(0, node);
    	}
        return val;
    }
    
    public void put(int key, int value) {
    	Node node = new Node(key, value);
        if (list.size() < capacity) {
        	if (map.containsKey(key)) {
        		list.remove(map.get(key));
        	}
        	list.add(0, node);
        	map.put(key, node);
        } else {
        	if (map.containsKey(key)) {
        		list.remove(map.get(key));
        	} else {
        		Node nodeLast = list.remove(list.size() - 1);
            	map.remove(nodeLast.key);
        	}
     		map.put(key, node);
       		list.add(0, node);
        }
    }
    
	public static void main(String[] args) {
		LRUCache obj = new LRUCache(2);
		obj.put(1, 1);
		obj.put(2, 2);
		System.out.println(obj.get(1));
		obj.put(3, 3);
		System.out.println(obj.get(2));
		obj.put(4, 4);
		System.out.println(obj.get(1));
		System.out.println(obj.get(3));
		System.out.println(obj.get(4));
	}

}
