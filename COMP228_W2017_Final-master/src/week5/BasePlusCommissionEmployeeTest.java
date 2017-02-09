package week5;

public class BasePlusCommissionEmployeeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BasePlusCommissionEmployee employee = new BasePlusCommissionEmployee("Wallace", "Balaniuc",
				"123-45-678", 5000, 0.04, 300);
		
		// Print employee information
		System.out.println("Employee information obtained by get methods: ");
		System.out.printf("%n%s %s%n", "First Name is", employee.getFirstName());
		System.out.printf("%s %s%n", "Last name is", employee.getLastName());
		System.out.printf("%s %s%n", "Social security number is", employee.getSocialSecurityNumber());
		System.out.printf("%s %.2f%n", "Gross sales is", employee.getGrossSales());
		System.out.printf("%s %.2f%n", "Commission rate is", employee.getCommissionRate());
		System.out.printf("%s %.2f%n", "Base salary is", employee.getBaseSalary());
		
		employee.setBaseSalary(1000);
		
		System.out.printf("%n%s:%n%n%s%n", "Update employee information obtained by toString", employee);
	}

}








