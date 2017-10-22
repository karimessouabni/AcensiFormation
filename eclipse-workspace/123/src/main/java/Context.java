import java.util.Date;

public class Context {

	private Pricer pricer;

	public Context(Pricer pricer) {
		this.pricer = pricer;
	}

	public Double executePricer(Date pricingDate) {
		return pricer.priceFinancialAsset(pricingDate);
	}

}
