package week4;

import java.util.EnumSet;

public class EnumTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("All books:");
		
		// Print all values of the Book enum
		for(Book book : Book.values()) {
			System.out.printf("%-10s%-45s%s%n", book, book.getTitle(), book.getCopyrightYear());
		}
		
		System.out.printf("%n%nDisplay a range of enum constants:%n");
		
		// Print a subset of Books using the EnumSet.range method
		for(Book book : EnumSet.range(Book.JHTP, Book.CPPHTP)) {
			System.out.printf("%-10s%-45s%s%n", book, book.getTitle(), book.getCopyrightYear());
		}
	}
}
