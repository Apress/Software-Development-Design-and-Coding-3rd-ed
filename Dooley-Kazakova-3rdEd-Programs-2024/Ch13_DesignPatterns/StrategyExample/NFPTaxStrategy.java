public class NFPTaxStrategy implements TaxStrategy { 

	private final double RATE = 0.0;

	public double computeTax(double income) {
		return income * RATE;
	}
}
