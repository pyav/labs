/**
 * https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/description/
 * 
 * Output:
 * ------
 * 2
 * 2
 * 2
 * 2
 * 2
 * 1
 * 2
 * 1
 * 2
 * 2
 * 2
 */

import java.util.*;

public class InsertDeleteGetRandomDuplicatesAllowed {
	
	private List<Integer> list;
    private Map<Integer, Set<Integer>> map;
    private Random rand;
	
	public InsertDeleteGetRandomDuplicatesAllowed() {
		list = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
    	boolean isNew = !map.containsKey(val);

        map.computeIfAbsent(val, k -> new HashSet<>()).add(list.size());
        list.add(val);

        return isNew;
    }
    
    public boolean remove(int val) {
    	if (!map.containsKey(val)) return false;

        int idx = map.get(val).iterator().next();
        int lastIndex = list.size() - 1;
        int lastVal = list.get(lastIndex);

        map.get(val).remove(idx);

        if (idx != lastIndex) {
            list.set(idx, lastVal);

            map.get(lastVal).remove(lastIndex);
            map.get(lastVal).add(idx);
        }

        list.remove(lastIndex);

        if (map.get(val).isEmpty()) {
            map.remove(val);
        }

        return true;
    }
    
    public int getRandom() {
    	return list.get(rand.nextInt(list.size()));
    }

	public static void main(String[] args) {
		InsertDeleteGetRandomDuplicatesAllowed obj = new InsertDeleteGetRandomDuplicatesAllowed();
		obj.insert(1);
		obj.insert(1);
		obj.insert(1);
		obj.insert(1);
		obj.remove(2);
		obj.insert(2);
		obj.insert(2);
		obj.insert(2);
		obj.insert(2);
		obj.insert(2);
		obj.insert(2);
		System.out.println(obj.getRandom());
		System.out.println(obj.getRandom());
		System.out.println(obj.getRandom());
		System.out.println(obj.getRandom());
		System.out.println(obj.getRandom());
		System.out.println(obj.getRandom());
		System.out.println(obj.getRandom());
		System.out.println(obj.getRandom());
		System.out.println(obj.getRandom());
		System.out.println(obj.getRandom());
		System.out.println(obj.getRandom());
	}

}
