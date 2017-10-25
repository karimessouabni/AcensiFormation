import java.util.Date;

public interface IRateRepository {

	RateCurve getRate(Date d);

}
