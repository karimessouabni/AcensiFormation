import java.util.Calendar;
import java.util.Date;

public abstract class AbstractPricer implements Pricer {

	FinancialAsset f;

	public FinancialAsset getF() {
		return f;
	}

	public void setF(FinancialAsset f) {
		this.f = f;
	}

}
