package week5;

public class CommissionEmployee {
	private final String firstName;
	private final String lastName;
	private final String socialSecurityNumber;
	private double grossSales;
	private double commissionRate;
	
	// Constructor
	public CommissionEmployee(String firstName, String lastName, String ssn, 
			double grossSales, double commissionRate) {
		// Validate grossSale number
		if(grossSales < 0.0){
			throw new IllegalArgumentException("Gross sales must be >= 0.0");
		}
		
		// Validate commissionRate
		if(commissionRate <= 0.0 || commissionRate >= 1.0) {
			throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");
		}
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.socialSecurityNumber = ssn;
		this.grossSales = grossSales;
		this.commissionRate = commissionRate;
	}

	// GETTER AND SETTERS
	public double getGrossSales() {
		return grossSales;
	}

	public void setGrossSales(double grossSales) {
		// Validate grossSales
		if(grossSales < 0.0) {
			throw new IllegalArgumentException("Gross sales must be >= 0.0");
		}
		
		this.grossSales = grossSales;
	}

	public double getCommissionRate() {
		return commissionRate;
	}

	public void setCommissionRate(double commissionRate) {
		if(commissionRate <= 0.0 || commissionRate >= 1.0) {
			throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");
		}
		
		this.commissionRate = commissionRate;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}
	
	// Calculates earnings
	public double earnings() {
		return getCommissionRate() * getGrossSales();
	}
	
	@Override
	public String toString() {
		return String.format("%s: %s %s%n%s: %s%n%s: %.2f%n%s: %.2f", 
				"base-salaried commission employee", getFirstName(), getLastName(),
				"social security number", getSocialSecurityNumber(),
				"gross sales", getGrossSales(),
				"commission rate", getCommissionRate());
	}
}











