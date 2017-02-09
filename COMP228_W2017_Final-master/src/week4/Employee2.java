package week4;

public class Employee2 {
	// Static variable
	private static int count = 0;
	
	// Instance variables
	private String firstName;
	private String lastName;
	
	public Employee2(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		
		++count;
		
		System.out.printf("Employee constructor: %s %s; count = %d%n", firstName, lastName, count);
	}

	// Getters
	public static int getCount() {
		return count;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
}
