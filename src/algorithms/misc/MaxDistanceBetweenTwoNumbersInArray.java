/**
 * Following program calculates the maximum of the distances among integers in an array. 
 * A number is allowed to occur only twice at max in the array. 
 * 
 * Output
 * ------
 * Max distance = 6
 *
 *
 * @author pyav
 */

import java.util.*;

class MaxDistanceBetweenTwoNumbersInArray {

	public static int getMaxDistance(int[] array) {

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < array.length; i++) {
			int prevPosition = -1;

			if (map.containsKey(array[i])) {
				prevPosition = map.get(array[i]);
			} else {
				map.put(array[i], i + 1);
				continue;
			}

			int distance = (i + 1) - prevPosition;
			max = (distance > max) ? distance : max;
		}

		return max;
	}

	public static void main(String[] args) {

		int[] array = { 10, 15, 1, 3, 10, 1, 0, 15 };
		System.out.println("Max distance = " + Integer.toString(getMaxDistance(array)));
	}

}
