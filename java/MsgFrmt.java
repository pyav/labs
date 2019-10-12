/**
 * This program shows number segregation with comma.
 *
 * Output
 * ------
 * Hello/100,000,000
 *
 * @author pyav
 */

import java.text.MessageFormat;

public class MsgFrmt {

	public static void main(String[] args) {

		String a = MessageFormat.format("{0}/{1}", "Hello", 100000000);
		System.out.println(a);
	}

}
