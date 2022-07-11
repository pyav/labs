/**
 * https://leetcode.com/problems/keys-and-rooms/
 * 
 * Output:
 * ------
 * true
 * false
 */
package leetcode;

import java.util.List;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Arrays;

public class KeysAndRooms {

	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
		boolean[] visited = new boolean[rooms.size()];
		Arrays.fill(visited, false);
		int key = 0;
		visited[key] = true;
		Stack<Integer> keyStack = new Stack<Integer>();
		keyStack.addAll(rooms.get(key));

		while (!keyStack.isEmpty()) {
			key = keyStack.pop();
			if (!visited[key]) {
				visited[key] = true;
				for (int k : rooms.get(key)) {
					if (!visited[k]) {
						keyStack.push(k);
					}
				}
				//keyStack.addAll(rooms.get(key));
			}
		}

		for (int i = 0; i < rooms.size(); i++) {
			if (!visited[i]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		List<List<Integer>> rooms = new ArrayList<List<Integer>>();
		rooms.add(Arrays.asList(1));
		rooms.add(Arrays.asList(2));
		rooms.add(Arrays.asList(3));
		rooms.add(Arrays.asList());
		System.out.println(new KeysAndRooms().canVisitAllRooms(rooms));
		List<List<Integer>> rooms2 = new ArrayList<List<Integer>>();
		rooms2.add(Arrays.asList(1, 3));
		rooms2.add(Arrays.asList(3, 0, 1));
		rooms2.add(Arrays.asList(2));
		rooms2.add(Arrays.asList(0));
		System.out.println(new KeysAndRooms().canVisitAllRooms(rooms2));
	}

}

