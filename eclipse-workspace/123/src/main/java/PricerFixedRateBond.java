import java.util.Date;

public class PricerFixedRateBond extends AbstractPricer {

	private RateCurve fixedRatesValuesOfPricingDay;
	private LinearInterpolation linearInterpolation;

	public PricerFixedRateBond(Bond b, RateCurve r) throws Exception {
		super.f = b;
		if (r.getValues() == null)
			throw new Exception("No rate for this date");
		fixedRatesValuesOfPricingDay = r;
		linearInterpolation = new LinearInterpolation(r);
	}

	public PricerFixedRateBond() {
	}

	@Override
	public Double priceFinancialAsset(Date pricingDate) {

		Double p0Result = 0d;
		Double p = (double) ((double) ((Bond) f).periodicity / (double) 12);
		int maturity = ((Bond) f).maturity;
		Double coupon = ((Bond) f).getCoupon();
		Double alpha = null;
		try {
			alpha = getAlpha(pricingDate, true);
		} catch (Exception e) {
			e.printStackTrace();
		}

		double firstP = p;
		while (maturity >= p) {
			Double alphaPlusP = p - firstP + alpha;
			if (maturity == p) {// last deadline
				p0Result += (((Bond) f).value + coupon)
						/ Math.pow((1 + linearInterpolation.linearInterpolation(alphaPlusP)), alphaPlusP);
			} else {
				p0Result += coupon / Math.pow((1 + linearInterpolation.linearInterpolation(alphaPlusP)), alphaPlusP);
			}
			p += p;
		}

		return p0Result;
	}

	public RateCurve getRateCurveOfPricingDay() {
		return fixedRatesValuesOfPricingDay;
	}

	public void setRateCurveOfPricingDay(RateCurve rateCurveOfPricingDay) {
		this.fixedRatesValuesOfPricingDay = rateCurveOfPricingDay;
	}

	public Double getAlpha(Date pricingDate, boolean proportionalRate) throws Exception {
		int daysBetweenPricingAndNextFlux = DateUtils.nbrDaysBetween(pricingDate, ((Bond) f).nextFlux(pricingDate));
		return proportionalRate ? (double) daysBetweenPricingAndNextFlux / 365
				: (double) daysBetweenPricingAndNextFlux / 360;
	}

}
