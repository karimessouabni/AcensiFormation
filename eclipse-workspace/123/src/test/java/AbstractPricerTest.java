import java.text.ParseException;
import java.util.Date;

import org.junit.Test;

import junit.framework.Assert;

public class AbstractPricerTest {

	@Test
	public void testNbrDaysBetween() throws ParseException {

		PricerFixedRateBond pricer = new PricerFixedRateBond();

		Date dEmmission = DateUtils.parseDate("01/01/1992");
		Date dMaturity = DateUtils.parseDate("31/01/1992");

		Assert.assertEquals(DateUtils.nbrDaysBetween(dEmmission, dMaturity), 30);

	}

	@Test
	public void testMoreThanYearBetweeen() throws ParseException {

		PricerFixedRateBond pricer = new PricerFixedRateBond();

		Date d1 = DateUtils.parseDate("01/01/1992");
		Date d2 = DateUtils.parseDate("31/01/1992");
		Date d3 = DateUtils.parseDate("31/01/1993");

		Assert.assertEquals(DateUtils.moreThanYearBetweeen(d1, d2), false);
		Assert.assertEquals(DateUtils.moreThanYearBetweeen(d1, d3), true);

	}

}
