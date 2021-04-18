/**
 * Need some rectification.
 */
package tests;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class T3 {

	public static int firstOccurrence(String s, String x) {
		/*Pattern pattern = Pattern.compile(x);
		Matcher matcher = pattern.matcher(s);*/
		// System.out.println(matcher.group());
		/*
		 * if (matcher.matches()) { return matcher.start(); }
		 */
		// return matcher.find() ? matcher.start() : -1;

		if (x.contains("*")) {
			// String[] arr = x.split(x, '*');
			int index = x.indexOf('*');
			String a = x.substring(0, index);
			String b = x.substring(index + 1, x.length());
			/*
			 * if (s.contains(arr[0])) { int idx = s.indexOf(arr[0])+arr[0].length(); if
			 * (s.substring(idx, s.length()).contains(arr[2])) { return idx-arr[0].length();
			 * } else { return -1; }
			 * 
			 * } else { return -1; }
			 */
			if (s.contains(a)) {
				int idx = s.indexOf(a) + a.length();
				if (s.substring(idx, s.length()).contains(b)) {
					return idx - a.length();
				} else {
					return -1;
				}
			} else {
				return -1;
			}
		} else {
			if (s.contains(x)) {
				return s.indexOf(x);
			} else {
				return -1;
			}
		}

	}

	public static void main(String[] args) {
		System.out.println(T3.firstOccurrence("q", "*"));
	}

}
