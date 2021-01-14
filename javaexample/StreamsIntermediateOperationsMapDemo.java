/**
 * Following code is to showcase the use of map in streams.
 * 
 * Output
 * ------
 * 1
 * 4
 * 9
 * 16
 * 25
 *
 *
 * @author pyav
 */

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsIntermediateOperationsMapDemo {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		List<Integer> squares = numbers.stream().map(x -> x * x).collect(Collectors.toList());
		for (Integer i : squares) {
			System.out.println(i);
		}

	}

}
