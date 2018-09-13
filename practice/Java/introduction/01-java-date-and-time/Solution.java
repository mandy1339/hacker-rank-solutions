import java.util.Calendar;
import java.util.GregorianCalendar;



public class Solution {
public static String getDay(String day, String month, String year) {
    int d = Integer.parseInt(day);
        int m = Integer.parseInt(month) - 1;
        int y = Integer.parseInt(year);
        
        Calendar calendar = new GregorianCalendar(y, m, d);
        int dowInt = calendar.get(Calendar.DAY_OF_WEEK);
        
        String dowStr = "";
        
        final int mon = Calendar.MONDAY;
        final int tue = Calendar.TUESDAY;
        final int wed = Calendar.WEDNESDAY;
        final int thd = Calendar.THURSDAY;
        final int frd = Calendar.FRIDAY;
        final int sat = Calendar.SATURDAY;
        final int sun = Calendar.SUNDAY;
        
        switch(dowInt) {
            case mon: dowStr = "MONDAY";
                break;
            case tue: dowStr = "TUESDAY";
                break;
            case wed: dowStr = "WEDNESDAY";
                break;
            case thd: dowStr = "THURSDAY";
                break;
            case frd: dowStr = "FRIDAY";
                break;
            case sat: dowStr = "SATURDAY";
                break;
            case sun: dowStr = "SUNDAY";
                break;
        }
        
        return dowStr;
}
