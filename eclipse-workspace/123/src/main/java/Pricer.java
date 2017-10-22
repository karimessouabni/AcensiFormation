import java.util.Date;

public interface Pricer {

	Double priceFinancialAsset(Date pricingDate);

	static Double linearInterpolation(Rate r, Double x) {
		return 0d;
	}
}