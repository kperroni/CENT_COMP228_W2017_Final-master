package week6;

public class HourlyEmployee extends Employee {

	private double wage;
	private double hours;

	public HourlyEmployee(String firstName, String lastName, String socialSecurityNumber, double wage, double hours) {
		super(firstName, lastName, socialSecurityNumber);

		// Check if wage is valid
		if (wage < 0.0)
			throw new IllegalArgumentException("Hourly wage must be >= 0.0");

		// Check if hours is valid
		if ((hours < 0.0) || (hours > 168.0))
			throw new IllegalArgumentException("Hours worked must be >= 0.0 and <= 168.0");

		this.wage = wage;
		this.hours = hours;
	}

	// Getters and Setters
	public double getWage() {
		return wage;
	}

	public void setWage(double wage) {

		// Check if wage is valid
		if (wage < 0.0)
			throw new IllegalArgumentException("Hourly wage must be >= 0.0");

		this.wage = wage;
	}

	public double getHours() {
		return hours;
	}

	public void setHours(double hours) {

		// Check if hours is valid
		if ((hours < 0.0) || (hours > 168.0))
			throw new IllegalArgumentException("Hours worked must be >= 0.0 and <= 168.0");
		
		this.hours = hours;
	}

	@Override
	public double earnings() {
		
		if(getHours() <= 40)
			return getWage() * getHours(); //No overtime
		
		else
			return 40 * getWage() + (getHours() - 40) * getWage() * 1.5; //With overtime
	}
	
	public String toString(){
		
		return String.format("Hourly employee: %s%n%s: $%.2f; %s: %.2f", super.toString(), "Hourly Wage", getWage(),
				"Hours worked", getHours());
	}

}
