
public class LinearInterpolation implements Interpolation {

	private RateCurve r;

	
	LinearInterpolation() {
	}
	
	LinearInterpolation(RateCurve r) {
		this.r = r;
	}

	/* 
	 * 	int xLeft = (int) Math.ceil(x); pour arrondir a la valeur int suivant du double x passé en parametre
	 * Prend en parmetre le alpha qui est un double ex : 0.2333
	 * (non-Javadoc)
	 * @see Interpolation#linearInterpolation(java.lang.Double)
	 */
	public Double linearInterpolation(Double x)  {

		if (x < 0 || x > r.getMaxHeaderValue())
			try {
				throw new Exception("Valeur du x erronée");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		Double yLeft = null;
		int xLeft = (int) Math.ceil(x);
		Double yRight = null;
		int xRight = (int) Math.ceil(x);

		if (xLeft == 0)
			yLeft = 0d;
		else {
			do {
				if (r.getValueof(xLeft) == null)
					xLeft--;
				else
					yLeft = r.getValueof(xLeft);
			} while (yLeft == null && xLeft > 0);
			if (xLeft == 0)
				yLeft = 0d;
		}

		do {
			if (r.getValueof(xRight) == null)
				xRight++;
			else
				yRight = r.getValueof(xRight);
		} while (yRight == null && xRight < r.getMaxHeaderValue());

		if (yRight == yLeft)
			return yRight;

		Double result = yLeft + (x - xLeft) * (yRight - yLeft) / (xRight - xLeft);
		return result;

	}

	public RateCurve getR() {
		return r;
	}

	public void setR(RateCurve r) {
		this.r = r;
	}
	

}
