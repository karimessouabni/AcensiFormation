import java.util.Date;
import java.util.HashMap;

public class Rate {

	 private Date date; 
	 private HashMap<Double, Double> values;
	 
	 
	 
	 
	public Rate(Date date, HashMap<Double, Double> values) {
		this.date = date;
		this.values = values;
	}




	public Date getDate() {
		return date;
	}




	public void setDate(Date date) {
		this.date = date;
	}




	public HashMap<Double, Double> getValues() {
		return values;
	}




	public void setValues(HashMap<Double, Double> values) {
		this.values = values;
	}
	 
	 
	 
	 
	 
	
	public Double getValueof(Double k) {
		return this.values.get(k);
	}
	 
}
