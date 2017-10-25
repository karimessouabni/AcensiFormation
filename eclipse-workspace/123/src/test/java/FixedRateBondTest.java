import java.util.Date;

import org.junit.Test;

import junit.framework.Assert;

public class FixedRateBondTest {

	@Test
	public void testNbrDayOfmaturity() throws Exception {

		Date dEmmission = DateUtils.parseDate("01/01/1992");
		Date dMaturity = DateUtils.parseDate("01/01/1994");
		Date dPrincing = DateUtils.parseDate("02/01/1992");

		FixedRateBond b = new FixedRateBond();
		b.setEmissionDate(dEmmission);
		b.setMaturity(2); // 2 years
		b.setPeriodicity(6);

		Assert.assertEquals(b.nextFlux(dPrincing), DateUtils.parseDate("01/07/1992"));
		Assert.assertEquals(b.nextFlux(dEmmission), DateUtils.parseDate("01/07/1992"));

	}

}
