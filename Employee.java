package fms;
public class Employee extends FlightObserver{
	private String workEmail;
	public Employee(String id,String name,String workEmail){
		super(id,name);
		this.workEmail=workEmail;
	}
	@Override
	public void update(String status,String flightNumber) {
		System.out.println("sending message to employee: "+fullName+" on work email "+workEmail);
		System.out.println("flight "+flightNumber+" status changed to "+status);
	}
	public String toString () {
		return id+" "+fullName+" "+workEmail;
	}
}

