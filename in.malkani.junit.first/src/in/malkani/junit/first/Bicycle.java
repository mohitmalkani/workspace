package in.malkani.junit.first;

public class Bicycle {
	private int cadence, gear, speed,id;
	private static int numberOfBicycles=0;
	
	private Bicycle(int cadence, int gear, int speed){
		this.cadence=cadence;
		this.gear=gear;
		this.speed=speed;
		id= ++numberOfBicycles;
	}
	
	public int getID(){
		System.out.println("The id is: "+id);
		return id;
	}
	
	public static int getNumberOfBicycles(){
		return numberOfBicycles;
	}
}

