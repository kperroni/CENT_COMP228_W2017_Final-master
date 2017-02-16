package week6;

public class Invoice implements Payable {

	// Variables
	private final String partNumber;
	private final String partDescription;
	private int quantity;
	private double pricePerItem;

	// Constructor
	public Invoice(String partNumber, String partDescription, int quantity, double pricePerItem) {

		// Check for valid quantity
		if (quantity < 0)
			throw new IllegalArgumentException("Quantity must be >= 0");

		// Check for valid pricePerItem
		if (pricePerItem < 0.0)
			throw new IllegalArgumentException("Price per item must be >= 0");

		this.quantity = quantity;
		this.partNumber = partNumber;
		this.partDescription = partDescription;
		this.pricePerItem = pricePerItem;
	}

	// Getters and Setters

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		// Check for valid quantity
		if (quantity < 0)
			throw new IllegalArgumentException("Quantity must be >= 0");
		this.quantity = quantity;
	}

	public double getPricePerItem() {
		return pricePerItem;
	}

	public void setPricePerItem(double pricePerItem) {
		// Check for valid pricePerItem
		if (pricePerItem < 0.0)
			throw new IllegalArgumentException("Price per item must be >= 0");
		this.pricePerItem = pricePerItem;
	}

	public String getPartNumber() {
		return partNumber;
	}

	public String getPartDescription() {
		return partDescription;
	}

	// Methods
	@Override
	public double getPaymentAmount() {
		
		return this.getQuantity() * this.getPricePerItem();
	}

	@Override
	public String toString() {
		return String.format("%s: %n%s: %s (%s) %n%s: %d %n%s: $%.2f", "Invoice", "Part number", getPartNumber(), getPartDescription(),
				"Quantity", getQuantity(), "Price per item", getPricePerItem());
	}
	
}
