package week10;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DivideByZeroWithExceptionHandling {

	public static int quotient(int numerator, int denominator) throws ArithmeticException {
		return numerator / denominator;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		boolean continueLoop = true;
		
		do{
			//Continue looping while the "while" statement is true 
			
			try{
				System.out.println("Please enter an integer numerator");
				int numerator = scanner.nextInt();
				
				System.out.println("Please enter an integer denominator");
				int denominator = scanner.nextInt();
				int result = quotient(numerator, denominator);
				
				System.out.printf("%nResult: %d / %d = %d%n", numerator, denominator, result);	
				continueLoop = false;
			}catch(ArithmeticException e){
				System.out.printf("%nException: %s%n", e.getStackTrace());
				System.out.printf("Zero is an invalid denominator. Please try again. %n%n");
			}
			catch(InputMismatchException ex){
				System.out.printf("%nException: %s%n", ex);
				scanner.nextLine();
				System.out.printf("You must enter integers. Please try again. %n%n");
			}
					}while(continueLoop);
		
		
	}

}
