/**
 * Following program returns the list of 2D co-ordinates which are the 
 * nearest ones from (0. 0) based on an input co-ordinates. 
 * 
 * Output
 * ------
 * [[1, -3]]
 * [[1, -1], [1, 2]]
 *
 * 
 * @author pyav
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class ShortestDestination {

	/**
	 * Method to get the distance on a 2D graph. It calculates from (0, 0).
	 * 
	 * @param x The x-part of the 2D co-ordinate.
	 * @param y The y-part of the 2D co-ordinate.
	 * @return The square root of addition of squares of x and y i.e. the distance.
	 */
	private int getdistanceFromTruck(int x, int y) {
		return (int) Math.sqrt(x*x + y*y);
	}
	
	/**
	 * Method to calculate the nearest number of destinations to deliver to.
	 * 
	 * @param numDestinations Total number of destinations.
	 * @param allLocations    List of (x, y) co-ordinates.
	 * @param numDeliveries   Number of destinations to deliver.
	 * @return List of (x, y) co-ordinates to deliver to.
	 */
	List<List<Integer>> ClosestDestinations(int numDestinations,
                                            List<List<Integer>> allLocations, 
                                            int numDeliveries)
	{
		Map<Integer, List<List<Integer>>> distanceCoOrdinatesMap = new HashMap<Integer, List<List<Integer>>>();
		// Iterate over all the values
		for (int i = 0; i < numDestinations; i++) {
			int x = allLocations.get(i).get(0);
			int y = allLocations.get(i).get(1);
			int distance = getdistanceFromTruck(x, y);
			List<Integer> oneVal = new ArrayList<Integer>();
			oneVal.add(x);
			oneVal.add(y);
			List<List<Integer>> currValues = distanceCoOrdinatesMap.get(distance);
			if (currValues == null) {
				currValues = new ArrayList<>();
			}
			currValues.add(oneVal);
			distanceCoOrdinatesMap.put(distance, currValues);
		}

		// Sort based on keys i.e. distance.
		Map<Integer, List<List<Integer>>> treeMap = new TreeMap<Integer, List<List<Integer>>>(distanceCoOrdinatesMap);
		// Return the required number of values as per the number of deliveries.
		Set<Entry<Integer, List<List<Integer>>>> s = treeMap.entrySet();
		Iterator<Entry<Integer, List<List<Integer>>>> it = s.iterator();
		int numSend = numDeliveries;
		List<List<Integer>> finalVal = new ArrayList<>();
		// Iterate over the entrySet
		while (it.hasNext() && numSend > 0) {
			List<List<Integer>> val = it.next().getValue();
			// Iterate over the list of list of Integers
			for (int i = 0; i < val.size() && numSend > 0; i++) {
				finalVal.add(val.get(i));
				numSend--;
			}
		}

		return finalVal;
	}
	
	public static void main(String[] args) {
		
		List<List<Integer>> allLocations = new ArrayList<>();
		ShortestDestination testObj = new ShortestDestination();
		
		// Construct an array list and call find the closest destination.
		allLocations.add(new ArrayList<Integer>(Arrays.asList(1, -3)));
		System.out.println(testObj.ClosestDestinations(allLocations.size(), allLocations, 1).toString());
		
		// Clear the previous array list and construct a new one.
		allLocations.clear();
		allLocations.add(new ArrayList<Integer>(Arrays.asList(3, 4)));
		allLocations.add(new ArrayList<Integer>(Arrays.asList(1, -1)));
		allLocations.add(new ArrayList<Integer>(Arrays.asList(1, 2)));
		allLocations.add(new ArrayList<Integer>(Arrays.asList(1, -2)));
		System.out.println(testObj.ClosestDestinations(allLocations.size(), allLocations, 2).toString());
	}

}
