package week6;

public class SalariedEmployee extends Employee {

	private double weeklySalary;

	// Constructor
	public SalariedEmployee(String firstName, String lastName, String socialSecurityNumber, double weeklySalary) {
		super(firstName, lastName, socialSecurityNumber);

		// Check if weekly salary is invalid
		if (weeklySalary < 0.0)
			throw new IllegalArgumentException("Weekly salary must be >= 0.0");

		this.weeklySalary = weeklySalary;
	}

	//Getters and Setters
	public double getWeeklySalary() {
		return weeklySalary;
	}

	public void setWeeklySalary(double weeklySalary) {

		// Check if weekly salary is invalid
		if (weeklySalary < 0.0)
			throw new IllegalArgumentException("Weekly salary must be >= 0.0");
		
		this.weeklySalary = weeklySalary;
	}

	@Override
	public double earnings() {
		
		return getWeeklySalary();
	}

	@Override
	public String toString(){
		
		return String.format("Salaried employee: %s%n%s $%.2f", super.toString(), "Weekly salary", getWeeklySalary());
	}

	@Override
	public double getPaymentAmount() {
		// TODO Auto-generated method stub
		return getWeeklySalary();
	}
	
	
}
