import java.text.SimpleDateFormat;
import java.util.Date;

import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RefineryUtilities;

public class AppliactionTest {

	public static void main(String[] args) throws Exception {

		RateRepository rateRepo = new RateRepository("src/test/taux2.csv");

		Date dEmmission = DateUtils.parseDate("01/06/1993");
		FixedRateBond bond = new FixedRateBond(dEmmission, 2, 6, 1.5, 100d);
		Date dateEnds = DateUtils.getDateafternYears(dEmmission, bond.getMaturity());

		RateCurve rateCurve;
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		while (!dateEnds.equals(dEmmission)) {

			rateCurve = rateRepo.getRate(dEmmission);
			if (rateCurve == null || rateCurve.getValues() == null) {
				dEmmission = DateUtils.getNextDate(dEmmission);
				continue;
			}

			PricerFixedRateBond pricer = new PricerFixedRateBond(bond, rateCurve);
			Context ctx = new Context(pricer);

			Double result = ctx.executePricer(dEmmission);
			System.out.println("Pricing of " + dEmmission.toGMTString() + " : " + result);
			dEmmission = DateUtils.getNextDate(dEmmission);
			SimpleDateFormat formater = new SimpleDateFormat("yyyy/MM/DD");
			String datePricingFormated = formater.format(dEmmission);
			dataset.addValue(result, "Price", datePricingFormated);

		}


		ChartFinancialAsset chart = new ChartFinancialAsset("Bond Pricer", "Pricing a Bond", dataset);

		chart.pack();
		RefineryUtilities.centerFrameOnScreen(chart);
		chart.setVisible(true);

	}



}
