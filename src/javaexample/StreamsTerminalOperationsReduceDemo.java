/**
 * Following code is to showcase the use of forEach in streams.
 * 
 * Output
 * ------
 * 12
 *
 *
 * @author pyav
 */

import java.util.Arrays;
import java.util.List;

public class StreamsTerminalOperationsReduceDemo {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 6);
		System.out.println(numbers.stream().filter(x -> x % 2 == 0).reduce(0, (ans, i) -> ans+i));

	}

}
