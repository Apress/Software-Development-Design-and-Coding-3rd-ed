public class CorpTaxStrategy implements TaxStrategy { 

	private final double RATE = 0.45;

	public double computeTax(double income) {
		return income * RATE ;
	}
}

