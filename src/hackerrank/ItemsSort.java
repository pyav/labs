import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ItemsSort {

	public static List<Integer> itemsSort(List<Integer> items) {

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i : items) {
			if (map.containsKey(i)) {
				int val = map.get(i);
				map.put(i, 1 + val);
			} else {
				map.put(i, 1);
			}
		}

		List<Entry<Integer, Integer>> list = new LinkedList<Entry<Integer, Integer>>(map.entrySet());
		Collections.sort(list, new Comparator<Entry<Integer, Integer>>() {
			public int compare(Entry<Integer, Integer> a, Entry<Integer, Integer> b) {
				return a.getValue().compareTo(b.getValue());
			}
		});

		Map<Integer, List<Integer>> newMap = new HashMap<Integer, List<Integer>>();
		for (Entry<Integer, Integer> entry : list) {
			if (newMap.containsKey(entry.getValue())) {
				List<Integer> tmpList = newMap.get(entry.getValue());
				tmpList.add(entry.getKey());
				newMap.put(entry.getValue(), tmpList);
			} else {
				List<Integer> tmpList = new ArrayList<Integer>();
				tmpList.add(entry.getKey());
				newMap.put(entry.getValue(), tmpList);
			}
		}

		List<Entry<Integer, List<Integer>>> list2 = new LinkedList<Entry<Integer, List<Integer>>>(newMap.entrySet());
		Collections.sort(list2, new Comparator<Entry<Integer, List<Integer>>>() {
			public int compare(Entry<Integer, List<Integer>> a, Entry<Integer, List<Integer>> b) {
				return a.getKey().compareTo(b.getKey());
			}
		});

		List<Integer> finalList = new ArrayList<Integer>();
		for (Entry<Integer, List<Integer>> entry : list2) {
			List<Integer> tmp = entry.getValue();
			tmp.sort(null);

			for (int i : tmp) {
				for (int j = 0; j < entry.getKey(); j++) {
					finalList.add(i);
				}
			}
		}

		return finalList;
	}

	public static void main(String[] args) {

		List<Integer> items = new ArrayList<Integer>();
		items.add(8);
		items.add(5);
		items.add(5);
		items.add(5);
		items.add(5);
		items.add(1);
		items.add(1);
		items.add(1);
		items.add(4);
		items.add(4);
		List<Integer> result = TwilioItemsSort.itemsSort(items);
		for (int i : result) {
			System.out.println(i);
		}
	}

}
