package week6;

public class PayrollSystemTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Create 4 example employees
		SalariedEmployee salariedEmployee = new SalariedEmployee("Kenny", "Perroni", "111-11-1111", 800.00);
		HourlyEmployee hourlyEmployee = new HourlyEmployee("Bob", "Barker", "222-22-2222", 16.75, 40);
		CommissionEmployee commissionEmployee = new CommissionEmployee("John", "Smith", "333-33-3333", 10000, 0.06);
		BasePlusCommissionEmployee basePlusCommissionEmployee = new BasePlusCommissionEmployee("Jane", "Doe",
				"444-44-4444", 5000, 0.04, 300);
		
		System.out.println("Employees processes individually");
		
		System.out.printf("%n%s%n%s: $%.2f%n%n", salariedEmployee, "earned", salariedEmployee.earnings());
		System.out.printf("%n%s%n%s: $%.2f%n%n", hourlyEmployee, "earned", hourlyEmployee.earnings());
		System.out.printf("%n%s%n%s: $%.2f%n%n", commissionEmployee, "earned", commissionEmployee.earnings());
		System.out.printf("%n%s%n%s: $%.2f%n%n", basePlusCommissionEmployee, "earned", basePlusCommissionEmployee.earnings());
		
		//Create an array of employees
		Employee[] employee = new Employee[4];
		
		//Add all employees to the array
		employee[0] = salariedEmployee;
		employee[1] = hourlyEmployee;
		employee[2] = commissionEmployee;
		employee[3] = basePlusCommissionEmployee;
		
		System.out.println("Employees processed polymorphically");
		System.out.println();
		
		for(Employee currentEmployee : employee){
			
			System.out.println(currentEmployee);
			
			//Check if current employee is of type BasePlusCommissionEmployee
			if(currentEmployee instanceof BasePlusCommissionEmployee){
				
				//Creating BasePlusCommissionEmployee from generic employee objects
				BasePlusCommissionEmployee employee2 = (BasePlusCommissionEmployee)currentEmployee;
				
				//Set salary
				employee2.setBaseSalary(1.10 * employee2.getBaseSalary());
				
				System.out.printf("New base salary with 10%% increase is: $%.2f%n", employee2.getBaseSalary());
			}
			
			
			System.out.printf("Earned: $%.2f%n%n", currentEmployee.earnings());
			
		}
		
		for (int i = 0; i < employee.length; i++) {
			
			System.out.printf("Employee %d is a %s%n", i, employee[i].getClass().getName());
		}
	}

}
