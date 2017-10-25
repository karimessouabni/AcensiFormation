import java.text.ParseException;
import java.util.Date;

import junit.framework.Assert;
import junit.framework.TestCase;

public class RateRepositoryTest extends TestCase {

	
	
	public void testParse() throws ParseException {
		{
			RateRepository rateRepo = new RateRepository(
					"src/test/taux2.csv");
			Assert.assertEquals(120, rateRepo.header.size());
			Assert.assertEquals((Integer)25, rateRepo.header.get(0));
			Assert.assertEquals((Integer)50, rateRepo.header.get(1));
			
			Date date = DateUtils.parseDate("04/01/1993");

			Assert.assertEquals(0.068079038d, rateRepo.getRate(date).getValueof(25));
		}
	}
}
