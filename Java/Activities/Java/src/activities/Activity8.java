package activities;

public class Activity8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CustomException ce;
		
		try {
			// Call method with some message.
			Activity8.exceptionTest("Will print to console");
			ce = new CustomException("Value Passed before null.");
			// Call method with some string.
			System.out.println("When passed string before null :"+ce.getMessage());
			Activity8.exceptionTest(null);			
			Activity8.exceptionTest("Won't execute");
			
		} catch (CustomException e) {
			System.out.println("Inside catch block: " + e.getMessage());
		}
	}
	
	static void exceptionTest(String str) throws CustomException
	{
		if(str==null) {
			throw new CustomException("String value is null");
		}
		else
		{
			System.out.println(str);
		}
	}

}