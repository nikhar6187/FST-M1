package activities;

public class Activity3 {

	public static void main(String[] args) {
	
		double seconds = 1000000000;
	
		double EarthSeconds = 31557600; 
		double MercurySeconds = 0.2408467;
		double VenusSeconds = 0.61519726;
		double MarsSeconds = 1.8808158;
		double JupiterSeconds = 11.862615;
		double SaturnSeconds = 29.447498;
		double UranusSeconds = 84.016846;
		double NeptuneSeconds = 164.79132;
		
		System.out.println("Age on EARTH is: "+seconds/(365.25*24*3600) +"Earth Years");
		System.out.println("Age on MERCURY is: "+seconds/EarthSeconds/MercurySeconds +"Earth Years");
		System.out.println("Age on VENUS is: "+seconds/EarthSeconds/VenusSeconds +"Earth Years"); 
		System.out.println("Age on MARS is: "+seconds/EarthSeconds/MarsSeconds +"Earth Years"); 
		System.out.println("Age on JUPITER is: "+seconds/EarthSeconds/JupiterSeconds +"Earth Years");
		System.out.println("Age on SATURN is: "+seconds/EarthSeconds/SaturnSeconds +"Earth Years");
		System.out.println("Age on URANUS is: "+seconds/EarthSeconds/UranusSeconds +"Earth Years");
		System.out.println("Age on NEPTUNE is: "+seconds/EarthSeconds/NeptuneSeconds +"Earth Years");
		
	}

}
