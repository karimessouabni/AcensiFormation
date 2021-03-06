import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class RateRepository implements IRateRepository {

	String path;
	HashMap<Date, RateCurve> ratesMap;
	Logger logger = Logger.getAnonymousLogger();
	List<Integer> header = new ArrayList<Integer>();
	Integer maxHeaderValue = 0 ;

	public RateRepository(String path) {
		this.path = path;
		// pars file into rates
		parseAllRates(path);

	}


	public void parseAllRates(String path) {

		ratesMap = new HashMap<>();
		try {
			File inputF = new File(path);
			InputStream inputFS = new FileInputStream(inputF);
			BufferedReader br = new BufferedReader(new InputStreamReader(
					inputFS));
			// construct the header
			this.getHeader(br.readLine());

			// skip the header of the csv
			br.lines().map(mapToItem)
					.forEach(entry -> ratesMap.put(entry.getDate(), entry));
			br.close();

		} catch (IOException e) {
			logger.log(Level.SEVERE, "Reading file Exception", e);
		}

	}

	private Function<String, RateCurve> mapToItem = (line) -> {
		String[] p = line.split(";");
		Date dateformated = null;
		try {
			dateformated = formatDate(p[0]);
		} catch (ParseException e) {
			logger.log(Level.SEVERE, "Parsing Exception", e);
		}

		HashMap<Integer, Double> values = new HashMap<>();
		if (p[1].equals(" na"))
			values = null; // pas de valeurs
		else
			for (int i = 1; i <= this.header.size(); i++) {
				values.put(this.header.get(i - 1), Double.valueOf(p[i]));
			}
		return new RateCurve(dateformated, values, maxHeaderValue);
	};

	private void getHeader(String line) {
		String[] p = line.split(";");// a CSV has comma separated lines
		for (String s : p) {
			int start = s.indexOf('C') + 1;
			int end = s.indexOf('Y');
			if (start != 0 || end != -1) {
				Integer headerValue = Integer.valueOf(s.substring(start, end)) ;
				this.header.add(headerValue);
				this.maxHeaderValue = (this.maxHeaderValue < headerValue)? headerValue : maxHeaderValue ;

			}
		}

	}

	private Date formatDate(String p) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = formatter.parse(p);
		return date;
	}

	/**
	 * @param d
	 * @return
	 * O(1) complexity to get a Rate by its date
	 */
	@Override
	public RateCurve getRate(Date d) {

		return this.ratesMap.get(d);
		

	}
	
	


	private Consumer<RateCurve> getRate = (line) -> {

	};
}
