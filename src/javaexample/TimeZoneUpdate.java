package random;

import java.util.Calendar;
import java.util.TimeZone;

public class TimeZoneUpdate {

	public static void main(String[] args) {
		Calendar inst = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
		inst.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
		System.out.println(inst.getTimeZone());
	}

}
