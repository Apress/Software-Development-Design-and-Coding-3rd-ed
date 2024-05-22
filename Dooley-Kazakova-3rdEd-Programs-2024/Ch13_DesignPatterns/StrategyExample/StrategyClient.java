/**
 * the client class that uses the strategy classes 
 */
public class StrategyClient {

	public static void main(String [] args) {
		double income;
		TaxPayerContext tp;

		income = 35000.00;
		tp = new TaxPayerContext(new PersonalTaxStrategy(), income);

		System.out.println("Tax is " + tp.computeTax());

		tp.setStrategy(new CorpTaxStrategy());
		System.out.println("Tax is " + tp.computeTax());
	}
}
