public class TaxPayerContext { 

	private TaxStrategy strategy;
	private double income;

	/* constructor for Context */
	public TaxPayerContext(TaxStrategy strategy, double income) {
		this.strategy = strategy;
		this.income = income;
	}

	public double getIncome() {
		return income;
	}   

	public void setIncome(double income) {
		this.income = income;
	}

	public TaxStrategy getStrategy() {
		return strategy;
	}   

	public void setStrategy(TaxStrategy strategy) {
		this.strategy = strategy;
	}  

	public double computeTax() {
		return strategy.computeTax(income);
	}
}
