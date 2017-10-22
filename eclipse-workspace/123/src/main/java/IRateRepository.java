import java.util.Date;

public interface IRateRepository {

	void parseAllRates(String f);

	Rate getRate(String d);

}
