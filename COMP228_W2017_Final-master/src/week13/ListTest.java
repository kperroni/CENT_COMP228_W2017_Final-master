package week13;

import java.util.List;
import java.util.ListIterator;
import java.util.LinkedList;
import java.util.Iterator;

public class ListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] colours = {"BLACK", "YELLOW", "GREEN", "VIOLET", "SILVER"};
		List<String> list1 = new LinkedList<>();
		
		for (String c : colours) {
			list1.add(c);
		}
		
		String[] colours2 = {"GOLD", "WHITE", "BROWN", "BLUE", "GRAY", "SILVER"};
		List<String> list2 = new LinkedList<>();
		
		for (String c : colours2) {
			list2.add(c);
		}
		
		list1.addAll(list2);
		list2 = null; //Releases resources
		
		printList(list1);
		convertToUpperCaseString(list1);
		printList(list1);
	}
	
	private static void printList(List<String> list){
		System.out.printf("%nList:%n");
		
		for (String c : list) {
			System.out.printf("%s ", c);
		}
		
		System.out.println();
	}
	
	private static void convertToUpperCaseString(List<String> list){
		ListIterator<String> itr = list.listIterator();
		
		while(itr.hasNext()){
			String colour = itr.next();
			itr.set(colour.toLowerCase());
		}
	}

}
