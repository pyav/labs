package javaexample;

import java.util.Date;

public class DateFormat {

	public static void main(String[] args) {

		String createTime = "1606221440";
		
		System.out.println(new Date(Long.valueOf(createTime)).toString().getClass());
	}

}
