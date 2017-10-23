import java.util.Calendar;
import java.util.Date;

public abstract class Bond implements FinancialAsset {

	protected Date emissionDate;
	protected Date maturity; // date d'echeance
	protected int periodicity; // nombre de mois
	protected Double coupon;
	protected Double value;

	public Date getEmissionDate() {
		return emissionDate;
	}

	public void setEmissionDate(Date emissionDate) {
		this.emissionDate = emissionDate;
	}

	public Date getMaturity() {
		return maturity;
	}

	public void setMaturity(Date maturity) {
		this.maturity = maturity;
	}

	public int getPeriodicity() {
		return periodicity;
	}

	public void setPeriodicity(int periodicity) {
		this.periodicity = periodicity;
	}

	public Double getCoupon() {
		return coupon;
	}

	public void setCoupon(Double coupon) {
		this.coupon = coupon;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Date nextFlux(Date date) throws Exception {

		Date nextFlux = emissionDate;
		while (nextFlux.before(date) || nextFlux.equals(date) ) {

			Calendar cal = Calendar.getInstance();
			cal.setTime(nextFlux);
			cal.add(Calendar.MONTH, periodicity);
			nextFlux = cal.getTime();

		}
		if (nextFlux.after(maturity))
			throw new Exception("Date de nextFlux erronée !!");
		return nextFlux;
	}

}
