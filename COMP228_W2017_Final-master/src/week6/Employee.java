package week6;

public abstract class Employee {

	private final String firstName;
	private final String lastName;
	private final String socialSecurityNumber;

	// Constructor
	public Employee(String firstName, String lastName, String socialSecurityNumber) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.socialSecurityNumber = socialSecurityNumber;
	}

	// Getter methods
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	@Override
	public String toString() {

		return String.format("%s %s%nSocial security number: %s", getFirstName(), getLastName(),
				getSocialSecurityNumber());
	}

	// Abstract earnings method
	public abstract double earnings();
}
