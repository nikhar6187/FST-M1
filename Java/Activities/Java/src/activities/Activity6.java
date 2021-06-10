package activities;

import java.util.ArrayList;
import java.util.List;

public class Activity6 {

	public static void main(String[] args) throws InterruptedException {
		
		Plane plane = new Plane(10);
	
		plane.onBoard("Nivi");
		plane.onBoard("Aarna");
		plane.onBoard("Tanvi");
		plane.onBoard("Akash");
		
		System.out.println("Plane took off at: " + plane.takeOff());
		System.out.println("People on the plane: " + plane.getPassengers());
		Thread.sleep(10000);
		plane.land();
		System.out.println("Plane landed at: " + plane.getLastTimeLanded());
		System.out.println("People on the plane after landing: " + plane.getPassengers()); 


	}

}
