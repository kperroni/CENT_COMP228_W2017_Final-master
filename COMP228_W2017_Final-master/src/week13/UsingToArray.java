package week13;

import java.util.LinkedList;
import java.util.Arrays;

public class UsingToArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] colours = {"black", "blue", "yellow"};
		LinkedList<String> links = new LinkedList<>(Arrays.asList(colours));
		
		links.addLast("red");
		links.add("pink");
		links.add(3, "green");
		links.addFirst("cyan");
		
		colours = links.toArray(new String[links.size()]);
		
		System.out.println("Colours: ");
		
		for (String c : colours) {
			System.out.println(c);
		}
		
	}

}
