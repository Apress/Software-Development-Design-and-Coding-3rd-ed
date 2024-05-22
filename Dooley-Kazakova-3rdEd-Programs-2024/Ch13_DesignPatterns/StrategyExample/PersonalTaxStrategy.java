public class PersonalTaxStrategy implements TaxStrategy { 

	private final double RATE = 0.25;

	public double computeTax(double income) {
		if (income <= 25000.0) {
			return income * (0.75 * RATE);
		} else {
			return income * RATE;
		}
	}
}
