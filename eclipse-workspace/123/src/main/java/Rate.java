import java.util.Date;
import java.util.HashMap;

public class Rate implements Comparable<Rate> {

	 private Date date; 
	 private HashMap<Integer, Double> values;
	 
	 
	 
	 
	public Rate() {
		super();
		// TODO Auto-generated constructor stub
	}




	public Rate(Date date, HashMap<Integer, Double> values) {
		this.date = date;
		this.values = values;
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
	 
	 
	 
	 
	 
	
	/**
	 * @param k
	 * @return
	 * O(1) complexity to get a value of rate
	 */
	public Double getValueof(Integer k) {
		return this.values.get(k);
	}

	



	@Override
	public int compareTo(Rate o) {
		if(this.date.after(o.getDate())) return 1 ;
		else return -1;
	}
	 
}
