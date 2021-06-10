package activities;

import java.util.ArrayList;
import java.util.List;
import java.util.RandNitya;

public class Activity9 {

	public static void main(String[] args) {	
		
		List<String> myList = new ArrayList<String>();
		
		// Adding items sequentially.
		myList.add("Nikhar");
		myList.add("Vijay");
		myList.add("Vargiya");
		myList.add("Riya");
		myList.add("Nitya");
		
		// Adding an item at first location.
		myList.add(0, "Shinde");
		
		// Print the Array List.
		System.out.println("Current Arraylist  : "+myList);
		
		// Print all the names.
		for(int i=0;i<myList.size();i++)
		{
			System.out.println("The name is : "+myList.get(i));
		}
		
		// Print the third name.
		System.out.println("The third name is :"+myList.get(2));
		
		// Method to check if a name exists in the ArrayList
		for(int i=0;i<myList.size();i++)
		{
			if(myList.get(i).contains("Nitya"))
				System.out.println("The name exist in the list : "+myList.get(i));			
		}
	
		myList.set(5, "Alter"); 
	
		System.out.println("Arraylist after alteration : "+myList);
		
		
		System.out.println("The size of the list is : "+myList.size());
		
		
		myList.remove(4);
		
		
		System.out.println("The size of the list after removing a name is : "+myList.size());
	
		System.out.println("Arraylist after removing a name : "+myList);
		
	}

}
