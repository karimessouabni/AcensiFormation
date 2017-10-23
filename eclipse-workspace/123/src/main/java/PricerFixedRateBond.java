import java.util.Calendar;
import java.util.Date;

public class PricerFixedRateBond extends AbstractPricer {

	private RateCurve fixedRatesValuesOfPricingDay;
	private LinearInterpolation linearInterpolation;

	public PricerFixedRateBond(Bond b, RateCurve r) {
		super.f = b;
		fixedRatesValuesOfPricingDay = r;
		linearInterpolation = new LinearInterpolation(r);
	}

	public PricerFixedRateBond() {
	}

	@Override
	public Double priceFinancialAsset(Date pricingDate) {

		boolean actuarialRat = moreThanYearBetweeen(((Bond) f).getEmissionDate(), ((Bond) f).getMaturity()); // if
																													// false
																													// proportional
																													// Rate
		Double alpha = null;
		try {
			alpha = getAlpha(pricingDate, actuarialRat);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Double coupon = ((Bond)f).getCoupon();
		try {
			Double actuarialRatei = getActuarialRat(coupon, alpha, 0.5d);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	private Double getActuarialRat(Double coupon, Double alpha, Double variance) throws Exception {
		Double rAlpha = null;
		try {
			rAlpha = linearInterpolation.linearInterpolation(alpha);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(rAlpha == null) throw new Exception("Erreur lors de l'interpolation du alpha !");
		return coupon/Math.pow((1+rAlpha), rAlpha+variance) ; 
	}

	public RateCurve getRateCurveOfPricingDay() {
		return fixedRatesValuesOfPricingDay;
	}

	public void setRateCurveOfPricingDay(RateCurve rateCurveOfPricingDay) {
		this.fixedRatesValuesOfPricingDay = rateCurveOfPricingDay;
	}

	public Double getAlpha(Date pricingDate, boolean proportionalRate) throws Exception {
		int daysBetweenPricingAndNextFlux = nbrDaysBetween(pricingDate, ((Bond) f).nextFlux(pricingDate));
		return proportionalRate ? (double) daysBetweenPricingAndNextFlux / 365
				: (double) daysBetweenPricingAndNextFlux / 360;
	}

}
