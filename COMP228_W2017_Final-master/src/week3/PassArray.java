package week3;

public class PassArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Declare an integer array of size 5 with default values
		int[] myArray = {1, 2, 3, 4, 5};
		
		// User feedback
		System.out.printf("Effects of passing reference to entire array:%n" 
				+ "The values of the original array are: %n");
		
		// Iterate through initial array and print out values
		for(int val : myArray) {
			System.out.printf(" %d", val);
		}
		
		// Pass array reference to modifyArray
		modifyArray(myArray);
		System.out.printf("%n%nThe values of the modified array are:%n");
		
		// Iterate through array and print values
		for(int val : myArray) {
			System.out.printf(" %d", val);
		}
		
		// Print element at index value 3
		System.out.printf("%n%nEffects of passing array element value:%n"
				+ "array[3] before modifyElement: %d%n", myArray[3]);
		
		// Pass primitive type to array
		modifyElement(myArray[3]);
		
		// Print array
		for(int val : myArray) {
			System.out.printf(" %d", val);
		}
		
	}
	
	// Modifies array by reference type
	public static void modifyArray(int array2[]) {
		/*
		// Enhanced for-loop used to print and display elements in array
		for(int val : array2) {
			val *= 2;
		}
		*/
		// Traditional for-loop used to modify element within an array
		for(int counter = 0; counter < array2.length; counter++) {
			array2[counter] *= 2;
		}
	}
	
	// Primitive type provides a COPY of the data.
	public static void modifyElement(int element) {
		element *= 2;
		System.out.printf("Value of element in modifyElement: %d%n", element);
	}
}












