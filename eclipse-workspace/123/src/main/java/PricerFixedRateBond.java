import java.util.Date;

public class PricerFixedRateBond extends AbstractPricer {

	private Rate fixedRatesValuesOfPricingDay;

	public PricerFixedRateBond(FinancialAsset f, Rate r) {
		super.f = f;
		fixedRatesValuesOfPricingDay = r;
	}

	@Override
	public Double priceFinancialAsset(Date pricingDate) {

		return null;
	}

	public Rate getRateCurveOfPricingDay() {
		return fixedRatesValuesOfPricingDay;
	}

	public void setRateCurveOfPricingDay(Rate rateCurveOfPricingDay) {
		this.fixedRatesValuesOfPricingDay = rateCurveOfPricingDay;
	}
	
	

}
