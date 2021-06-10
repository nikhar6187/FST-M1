package activities;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

//import org.apache.poi.hpsf.Array;

public class Acitivity10 {

	public static void main(String[] args) {
		// Create a Hash Set.
		HashSet<String> hs = new HashSet<String>();
		
		// Add names to the hash set
		hs.add("Nikhar");
		hs.add("Vijay");
		hs.add("Vargiya");
		hs.add("Sowmya");
		hs.add("Venkat");
		hs.add("Nivi");
		
		System.out.println("The size of the Hash Set is :"+hs.size());
		
		// Print the hash set.
		System.out.println("The hash set is :"+hs);
		
		// Remove an item.
		hs.remove("Nivi");
		
		// Remove an item which is not present.
		hs.remove("Sports");
		
		// Verify if an item is in the set.
		if(hs.contains("Nikhar"))
			System.out.println("The set contains the item.");
		else
			System.out.println("The set does not contains the item.");
		
		// Print the updated set
		System.out.println("The updated set is :"+hs);

		// Clear all the items
		hs.clear();
		System.out.println("After clearing set :"+hs);
		
		if(hs.isEmpty())
			System.out.println("Hash set is empty.");
		else
			System.out.println("hash set is not empty.");	
		
	}

}
