import java.util.Date;
import java.util.TreeSet;

public class RateRepository implements IRateRepository {

	String path;
	TreeSet<Rate> rates;

	public RateRepository(String path) {
		this.path = path;
		//pars file into rates 
		parseAllRates(path);
		
	}

	@Override
	public void parseAllRates(String Path) {
		// TODO Auto-generated method stub

	}

	@Override
	public double getRate(Date d) {
		// TODO Auto-generated method stub
		return 0;
	}

}
