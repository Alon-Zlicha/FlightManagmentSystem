package fms;
import java.util.ArrayList;
public class Airport {
	private String airportName;
	private ArrayList<Flight> departuringFlights;
	private ArrayList<Flight> arrivingFlights; 
	public Airport(String airportname) {
		this.airportName=airportname;
		this.departuringFlights=new ArrayList<Flight>();
		this.arrivingFlights=new ArrayList<Flight>();
	}
	private int isInDeparturingList(Flight flight) {
		for(int i=0;i<this.departuringFlights.size();i++) {
			if(this.departuringFlights.get(i).getFlightNumber().equals(flight.getFlightNumber())) {
				return i;
			}
		}
		return -1;
	}
	private int isInArrivingList(Flight flight) {
		for(int i=0;i<this.arrivingFlights.size();i++) {
			if(this.arrivingFlights.get(i).getFlightNumber().equals(flight.getFlightNumber())) {
				return i;
			}
		}
		return -1;
	}
	public void addDeparturingFlight(Flight flight) {
		if(isInDeparturingList(flight)!=-1) {
			System.out.println("cant add flight/ flight already exists");
		}
		this.departuringFlights.add(flight);
	}
	public void addArrivingFlight(Flight flight) {
		if(isInArrivingList(flight)!=-1) {
			System.out.println("cant add flight/ flight already exists");
		}
		this.arrivingFlights.add(flight);
	}
	public void removeDeparturingFlight(Flight flight) {
		int index=isInDeparturingList(flight);
		if(index==-1) {
			System.out.println("cant find flight/flight already removed");
			return;
		}
		departuringFlights.remove(index);
	}
	public void removeArrivingFlight(Flight flight) {
		int index=isInArrivingList(flight);
		if(index==-1) {
			System.out.println("cant find flight/flight already removed");
			return;
		}
		arrivingFlights.remove(index);
	}
	public String getName() {
		return this.airportName;
	}
	public void printDeparturingFlights() {
		for(int i=0;i<departuringFlights.size();i++) {
			departuringFlights.get(i).printFlight();
		}
	}
	public void printArrivingFlights() {
		for(int i=0;i<arrivingFlights.size();i++) {
			arrivingFlights.get(i).printFlight();
		}
	}
}
