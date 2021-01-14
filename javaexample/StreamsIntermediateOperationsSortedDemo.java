/**
 * Following code is to showcase the use of sorted in streams.
 * 
 * Output
 * ------
 * a
 * good
 * is
 * pyav
 *
 *
 * @author pyav
 */

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsIntermediateOperationsSortedDemo {

	public static void main(String[] args) {
		List<String> sentence = Arrays.asList("pyav", "is", "a", "good");
		List<String> squares = sentence.stream().sorted().collect(Collectors.toList());
		for (String i : squares) {
			System.out.println(i);
		}

	}

}
