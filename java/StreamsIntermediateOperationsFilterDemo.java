/**
 * Following code is to showcase the use of filter in streams.
 * 
 * Output
 * ------
 * pyav.exe
 * good.exe
 *
 *
 * @author pyav
 */

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsIntermediateOperationsFilterDemo {

	public static void main(String[] args) {
		List<String> sentence = Arrays.asList("pyav.exe", "is.txt", "a.bat", "good.exe");
		List<String> squares = sentence.stream().filter(x -> x.endsWith(".exe")).collect(Collectors.toList());
		for (String i : squares) {
			System.out.println(i);
		}

	}

}
