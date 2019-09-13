/**
 * Following code searches a string pattern from a file.
 * 
 * NOTE: You need to update the file path to the test file.
 *  
 * Output
 * ------
 * pattern=/abc_xyz/0101010/
 * 
 * 
 * @author pyav
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcher {

	public static void main(String[] args) {

		final String pattern = "pattern";
		Pattern ptrnComp = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
		final String filePath = "<Path to file's parent directory>/test_file.txt";
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
			String s = null;
			while ((s = in.readLine()) != null) {
				Matcher m = ptrnComp.matcher(s);
				if (m.find()) {
					System.out.println(s);
				}

			}

			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
