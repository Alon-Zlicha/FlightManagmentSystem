package fms;

public class Passenger extends FlightObserver {
	private String email;
	private String phone;
	public Passenger(String id,String name,String email,String phone){
		super(id,name);
		this.email=email;
		this.phone=phone;
	}
	@Override
	public void update(String status,String flightNumber) {
		System.out.println("sending message to passenger: "+fullName+" on email "+email+" and on phone "+phone);
		System.out.println("flight "+flightNumber+" status changed to "+status);
	}
	public String toString() {
		return id+" "+fullName+" "+email+" "+" "+phone;
	}
}
