package week6;

public class PolymorphismTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Create commission employee object
		CommissionEmployee commissionEmployee = new CommissionEmployee("Kenny", "Perroni", "123-4567", 20000, 0.1);
		
		//Create basepluscommission employee object
		
		BasePlusCommissionEmployee basePlusCommissionEmployee = new BasePlusCommissionEmployee("Bob", "Barker", "567-8910", 5000, 0.05, 10);
		
		System.out.printf("%s %s:%n%n%s%n%n", "Call CommissionEmployee's toString with superclass reference",
				"to superclass object", commissionEmployee.toString());
		
		System.out.printf("%s %s:%n%n%s%n%n", "Call BasePlusCommissionEmployee's toString with superclass reference",
				"to superclass object", basePlusCommissionEmployee.toString());
		
		CommissionEmployee commissionEmployee2 = basePlusCommissionEmployee;
		
		System.out.printf("%s %s:%n%n%s%n%n", "Call BasePlusCommissionEmployee's toString with superclass reference",
				"to superclass object", commissionEmployee2.toString());
	}

}
