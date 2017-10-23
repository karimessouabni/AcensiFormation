import java.util.Calendar;
import java.util.Date;

public abstract class AbstractPricer implements Pricer {

	FinancialAsset f;

	public int nbrDaysBetween(Date d1, Date d2) {
		return (int) ((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
	}

	public boolean moreThanYearBetweeen(Date d1, Date d2) {

		Calendar cal = Calendar.getInstance();
		cal.setTime(d1);
		cal.add(Calendar.YEAR, 1);
		Date d1Plus1Year = cal.getTime();
		return (d2.after(d1Plus1Year)) ? true : false;

	}

	public FinancialAsset getF() {
		return f;
	}

	public void setF(FinancialAsset f) {
		this.f = f;
	}
	
	

}
