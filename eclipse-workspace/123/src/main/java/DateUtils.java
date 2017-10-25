import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

	public static int nbrDaysBetween(Date d1, Date d2) {
		return (int) ((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
	}

	public static boolean moreThanYearBetweeen(Date d1, Date d2) {

		Calendar cal = Calendar.getInstance();
		cal.setTime(d1);
		cal.add(Calendar.YEAR, 1);
		Date d1Plus1Year = cal.getTime();
		return (d2.after(d1Plus1Year)) ? true : false;

	}

	public static Date getNextDate(Date d1) {

		Calendar cal = Calendar.getInstance();
		cal.setTime(d1);
		cal.add(Calendar.DATE, 1);
		return cal.getTime();

	}
	
	public static Date getDateafternYears(Date d1, int years) {

		Calendar cal = Calendar.getInstance();
		cal.setTime(d1);
		cal.add(Calendar.YEAR, years);
		return cal.getTime();

	}
	
	

	public static final Date parseDate(String date) throws ParseException{
		final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
	return getNextDate( simpleDateFormat.parse(date));
	
	}

}
