package week13;

public class TowersOfHanoi {

	public static void solveTowers(int disks, int sourcePeg, int destinationPeg, int tempPeg){
		if(disks == 1){
			System.out.printf("%n%d --> %d", sourcePeg, destinationPeg);
			return;
		}
		
		//Recursion
		//Move (disk -1) from sourcePeg to tempPeg using destinationPeg
		solveTowers(disks - 1, sourcePeg, tempPeg, destinationPeg);
		
		System.out.printf("%n%d --> %d", sourcePeg, destinationPeg);
		
		//Move (disks -1) from tempPeg to destinationPeg
		solveTowers(disks - 1, tempPeg, destinationPeg, sourcePeg);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int startPeg = 1;
		int endPeg = 2;
		int tempPeg = 3;
		int totalDisks = 3;
		
		solveTowers(totalDisks, startPeg, endPeg, tempPeg);
		
	}

}
