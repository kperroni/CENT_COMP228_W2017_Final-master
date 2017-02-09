package week4;

public enum Book {
	// Declare constants
	JHTP("Java How to Program", "2015"), 
	CHTP("C How to program", "2013"),
	IW3HTP("Internet & World Wide Web How to Program", "2012"),
	CPPHTP("C++ How to Program", "2014"),
	VBHTP("Visual Basic How to Program", "2014"),
	CSHARPHTP("Visual C# How to Program", "2014");
	
	///////////////////////////////////////////
	
	// Declare instance fields
	private final String title;
	private final String copyrightYear;
	
	// Declare constructor
	Book(String title, String copyrightYear) {
		this.title = title;
		this.copyrightYear = copyrightYear;
	}

	// getMethods
	public String getTitle() {
		return title;
	}

	public String getCopyrightYear() {
		return copyrightYear;
	}
}







