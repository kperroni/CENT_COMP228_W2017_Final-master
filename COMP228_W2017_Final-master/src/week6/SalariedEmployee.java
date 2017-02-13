package week6;

public class SalariedEmployee extends Employee {

	private double weeklySalary;
	
	public SalariedEmployee(String firstName, String lastName, String socialSecurityNumber, double weeklySalary) {
		super(firstName, lastName, socialSecurityNumber);
		
	}
	
	@Override
	public double earnings() {
		// TODO Auto-generated method stub
		return 0;
	}

}
