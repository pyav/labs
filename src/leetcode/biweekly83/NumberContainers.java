/**
 * https://leetcode.com/contest/biweekly-contest-83/problems/design-a-number-container-system/
 * 
 * Output:
 * ------
 * 1
 * -1
 * 1
 * -1
 * indicesMap: 1 20
 * map: 20 1
 * map: 10
 */

package leetcode.biweekly83;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class NumberContainers {

	Map<Integer, Integer> indicesMap;
	Map<Integer, PriorityQueue<Integer>> map;

	public Map<Integer, Integer> getIndicesMap() {
		return indicesMap;
	}

	public Map<Integer, PriorityQueue<Integer>> getMap() {
		return map;
	}

	public NumberContainers() {
		indicesMap = new HashMap<Integer, Integer>();
		map = new HashMap<Integer, PriorityQueue<Integer>>();
	}

	public void change(int index, int number) {
		if (indicesMap.containsKey(index)) {
			int val = indicesMap.get(index);
			if (val != number) {
				PriorityQueue<Integer> pq = map.get(val);
				if (pq != null) {
					pq.remove(index);
					map.put(val, pq);
					indicesMap.put(index, number);
					if (map.containsKey(number)) {
						PriorityQueue<Integer> pqTemp = map.get(number);
						pqTemp.add(index);
						map.put(number, pqTemp);
					} else {
						PriorityQueue<Integer> pqNew = new PriorityQueue<Integer>();
						pqNew.add(index);
						map.put(number, pqNew);
					}
				}
			}
		} else {
			indicesMap.put(index, number);
			if (map.containsKey(number)) {
				PriorityQueue<Integer> pqTemp = map.get(number);
				pqTemp.add(index);
				map.put(number, pqTemp);
			} else {
				PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
				pq.add(index);
				map.put(number, pq);
			}
		}
	}

	public int find(int number) {
		if (map.containsKey(number)) {
			if (map.get(number).size() == 0) {
				return -1;
			}
			return map.get(number).peek();
		}
		return -1;
	}

	public static void main(String[] args) {
		NumberContainers obj = new NumberContainers();
		obj.change(1, 10);
		System.out.println(obj.find(10));
		obj.change(1, 20);
		System.out.println(obj.find(10));
		System.out.println(obj.find(20));
		System.out.println(obj.find(30));
		/*obj.change(2, 10);
		obj.change(1, 10);
		obj.change(3, 10);
		obj.change(1, 20);
		obj.change(4, 100);*/
		for (Entry<Integer, Integer> entry : obj.getIndicesMap().entrySet()) {
			System.out.printf("indicesMap: %d %d", entry.getKey(), entry.getValue());
			System.out.println();
		}
		for (Entry<Integer, PriorityQueue<Integer>> entry : obj.getMap().entrySet()) {
			PriorityQueue<Integer> pq = entry.getValue();
			Iterator<Integer> itr = pq.iterator();
			System.out.printf("map: %d", entry.getKey());
			while (itr.hasNext()) {
				System.out.printf(" %d", itr.next());
			}
			System.out.println();
		}
		/*System.out.println(obj.find(10));
		System.out.println(obj.find(20));
		System.out.println(obj.find(100));*/
	}

}
