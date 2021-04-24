/**
 * Output:
 * ------
 * yadoT si yadnoM
 */

package javaexample;

public class ReverseSentence {
	public String reverseSentence(String str) {
		if (str == null || str.isEmpty()) {
			return "";
		}

		String[] splittedStr  = str.split(" ");
		String reversedStr = "";

		for(String i: splittedStr) {
			reversedStr += new StringBuilder(i).reverse().toString();
			reversedStr += " ";
		}

		return reversedStr.substring(0, reversedStr.length()-1);
	}

	public static void main(String[] args) {
		String str = "Today is Monday";
		System.out.println(new ReverseSentence().reverseSentence(str));
	}
}
