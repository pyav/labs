/**
 * https://leetcode.com/problems/determine-if-two-events-have-conflict/description/
 * 
 *  Output:
 *  ------
 *  true
 *  true
 *  false
 */

public class DetermineEventConflict {
	private int[] getTimeFromEvent(String eventTime) {
		String[] str = eventTime.split(":");
		int[] time = new int[2];
		time[0] = Integer.valueOf(str[0]);
		time[1] = Integer.valueOf(str[1]);
		return time;
	}
	
	private boolean isLesserTime(int[] time1, int[] time2) {
		if ((time1[0] < time2[0]) || ((time1[0] == time2[0]) && (time1[1] < time2[1]))) {
			return true;
		}
		return false;
	}
	
	public boolean haveConflict(String[] event1, String[] event2) {
        int[] event1StartTime = getTimeFromEvent(event1[0]);
        int[] event1EndTime = getTimeFromEvent(event1[1]);
        int[] event2StartTime = getTimeFromEvent(event2[0]);
        int[] event2EndTime = getTimeFromEvent(event2[1]);
        
        if (isLesserTime(event1EndTime, event2StartTime) || isLesserTime(event2EndTime, event1StartTime)) {
        	return false;
        }
        
        return true;
    }

	public static void main(String[] args) {
		System.out.println(new DetermineEventConflict().haveConflict(new String[]{"01:15","02:00"}, new String[] {"02:00","03:00"}));
		System.out.println(new DetermineEventConflict().haveConflict(new String[]{"01:00","02:00"}, new String[] {"01:20","03:00"}));
		System.out.println(new DetermineEventConflict().haveConflict(new String[]{"10:00","11:00"}, new String[] {"12:00","15:00"}));
	}

}
