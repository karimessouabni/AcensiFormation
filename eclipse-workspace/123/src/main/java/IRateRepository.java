import java.util.Date;

public interface IRateRepository {

	void parseAllRates(String f);

	double getRate(Date d);

}
