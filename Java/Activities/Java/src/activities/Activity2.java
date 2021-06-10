package activities;

public class Activity2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] num = {10, 77, 10, 54, -11, 10};
		int sum=0;
	
		for(int i=0;i<=5;i++)
		{
			if(num[i]==10)
			{
				sum = sum+num[i];
			}
		}
		if(sum==30)
			System.out.println("The total is :" +sum);
		else
			System.out.println("The total is not 30.");

	}

}
