package week4;

public class Employee2Test {
	public static void main(String[] args) {
		System.out.printf("Employees before instantiation: %d%n", Employee2.getCount());
		
		// Create employees
		Employee2 e1 = new Employee2("Wallace", "Balaniuc");
		Employee2 e2 = new Employee2("Bob", "Barker");
		
		System.out.printf("%nEmployees after instantiation:%n");
		System.out.printf("via e1.getCount(): %d%n", e1.getCount());
		System.out.printf("via e2.getCount(): %d%n", e2.getCount());
		System.out.printf("via Employee2.getCount(): %d%n", Employee2.getCount());
	}
}
