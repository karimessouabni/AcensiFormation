import java.util.Date;

public class Context {

	private Pricer pricer;

	public Context(Pricer pricer) {
		this.pricer = pricer;
	}

	public Double executePricer(Date pricingDate) throws Exception {
		return pricer.priceFinancialAsset(pricingDate);
	}

}
