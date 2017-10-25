import java.util.Date;

public class FixedRateBond extends Bond{

	public FixedRateBond(Date emissionDate, int maturity, int periodicity, Double coupon, Double value) {
		super.emissionDate = emissionDate;
		super.maturity = maturity;
		super.periodicity = periodicity;
		super.coupon = coupon;
		super.value = value;
	}

	public FixedRateBond() {
		
	}
	
	

}
