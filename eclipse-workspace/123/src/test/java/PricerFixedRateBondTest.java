import java.util.Date;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import junit.framework.Assert;

public class PricerFixedRateBondTest {

	@Mock
	FixedRateBond bond ;

	
	@Test
	public void testGetAlpha() throws Exception {
		bond = Mockito.mock(FixedRateBond.class);
		
		Date dEmmission = DateUtils.parseDate("01/01/2011");
		Date pricingDate = DateUtils.parseDate("25/01/2011");
		Date nextflux = DateUtils.parseDate("01/07/2011");
		
		Mockito.when(bond.getEmissionDate()).thenReturn(dEmmission);
		Mockito.when(bond.getMaturity()).thenReturn(2);
		Mockito.when(bond.nextFlux(pricingDate)).thenReturn(nextflux);
		Mockito.when(bond.nextFlux(dEmmission)).thenReturn(nextflux);
		
		
		PricerFixedRateBond pricer = new PricerFixedRateBond();
		pricer.setF(bond);
		Assert.assertEquals(0.4273972602739726, pricer.getAlpha(pricingDate, true));
		Assert.assertEquals(0.4931506849315068, pricer.getAlpha(dEmmission, true)); // environ 0.5
	}

	
	@Test
	public void testPriceFinancialAsset() throws Exception {
		bond = Mockito.mock(FixedRateBond.class);
		
		Date dEmmission = DateUtils.parseDate("01/01/2011");
		Date pricingDate = DateUtils.parseDate("01/01/2011");
		Date nextflux = DateUtils.parseDate("01/07/2011");
		
		Mockito.when(bond.getEmissionDate()).thenReturn(dEmmission);
		Mockito.when(bond.getMaturity()).thenReturn(2);
		Mockito.when(bond.nextFlux(pricingDate)).thenReturn(nextflux);
		Mockito.when(bond.nextFlux(dEmmission)).thenReturn(nextflux);
		
		
		PricerFixedRateBond pricer = new PricerFixedRateBond();
		pricer.setF(bond);
		Assert.assertEquals(0.4931506849315068, pricer.getAlpha(pricingDate, true));
		
	}

	
}

