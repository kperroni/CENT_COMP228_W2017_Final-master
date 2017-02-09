package week3;

import java.security.SecureRandom;

public class RollDie {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SecureRandom randomNumbers = new SecureRandom();
	
		
		int frequency1 = 0;	// Count of 1s rolled
		int frequency2 = 0;	// Count of 2s rolled
		int frequency3 = 0;	// Count of 3s rolled
		int frequency4 = 0;	// Count of 4s rolled
		int frequency5 = 0;	// Count of 5s rolled
		int frequency6 = 0;	// Count of 6s rolled
		
		// Iterate through a for loop 600000
		for(int roll = 1; roll <= 6000000; roll++) {
			int face = 1 + randomNumbers.nextInt(6);
			
			switch (face) {
				case 1:
					++frequency1;
					break;
				case 2:
					++frequency2;
					break;
				case 3:
					++frequency3;
					break;
				case 4:
					++frequency4;
					break;
				case 5:
					++frequency5;
					break;
				case 6:
					++frequency6;
					break;
			}
		}
		
		System.out.println("Face\tFrequency");
		System.out.printf("1\t%d%n2\t%d%n3\t%d%n4\t%d%n5\t%d%n6\t%d%n", frequency1, frequency2, frequency3, frequency4, frequency5, frequency6);
	}

}















