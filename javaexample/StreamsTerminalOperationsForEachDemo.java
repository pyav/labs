/**
 * Following code is to showcase the use of forEach in streams.
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

public class StreamsTerminalOperationsForEachDemo {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		numbers.stream().map(x -> x * x).forEach(y -> System.out.println(y));

	}

}
