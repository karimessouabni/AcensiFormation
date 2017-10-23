import java.util.Date;
import java.util.HashMap;

public class RateCurve implements Comparable<RateCurve> {

	private Date date;
	private HashMap<Integer, Double> values;
	private Integer maxHeaderValue;

	public RateCurve() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RateCurve(Date date, HashMap<Integer, Double> values, Integer maxHeaderValue) {
		this.date = date;
		this.values = values;
		this.maxHeaderValue = maxHeaderValue;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public HashMap<Integer, Double> getValues() {
		return values;
	}

	public void setValues(HashMap<Integer, Double> values) {
		this.values = values;
	}

	
	
	public Integer getMaxHeaderValue() {
		return maxHeaderValue;
	}

	public void setMaxHeaderValue(Integer maxHeaderValue) {
		this.maxHeaderValue = maxHeaderValue;
	}

	/**
	 * @param k
	 * @return O(1) complexity to get a value of rate
	 */
	public Double getValueof(Integer k) {
		return this.values.get(k);
	}

	@Override
	public int compareTo(RateCurve o) {
		if (this.date.after(o.getDate()))
			return 1;
		else
			return -1;
	}

}
