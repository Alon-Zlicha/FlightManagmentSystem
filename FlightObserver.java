package fms;

public abstract class FlightObserver implements Observer  {
	protected String id;
	protected String fullName;
	public FlightObserver(String id,String fullname) {
		this.id=id;
		this.fullName=fullname;
	}
	public String getID() {
		return this.id;
	}
	public abstract String toString();
}
