package fms;

import java.util.ArrayList;

public class Airline {
	private String airlineID;
	private String airlineName;
	private ArrayList<Airline> subAirlines;
	private ArrayList<Flight> flights;
	public Airline(String id, String name) {
		this.airlineID = id;
		this.airlineName = name;
		this.subAirlines = new ArrayList<>();
		this.flights = new ArrayList<>();
	}
	public void addSubAirline(Airline a) {
		if (a!=null && !subAirlines.contains(a)) {
			subAirlines.add(a);
		} else {
			System.out.println("Error: Cannot add sub airline.");
		}
	}
	public ArrayList<Airline> getSubAirlines(){
		return subAirlines;
	}
	public void removeSubAirline(Airline a) {
		if (a != null && subAirlines.contains(a)) {
			subAirlines.remove(a);
		} else {
			System.out.println("Error: Cannot remove sub airline.");
		}
	}
	public void addFlight(Flight flight) {
		if (flight != null && !flights.contains(flight)) {
			flights.add(flight);
		} else {
			System.out.println("Error: Cannot add flight.");
		}
	}
	public void removeFlight(Flight flight) {
		if (flight != null && flights.contains(flight)) {
			flights.remove(flight);
		} else {
			System.out.println("Error: Cannot remove flight.Flight already removed");
		}
	}
	public ArrayList<Flight> getAllFlights() {
		ArrayList<Flight> allFlights=new ArrayList<>(flights);
		for (Airline subAirline:subAirlines) {
			allFlights.addAll(subAirline.getAllFlights());
		}
		return allFlights;
	}
	public String getID() {
		return airlineID;
	}
	public String getName() {
		return airlineName;
	}
	public String toString() {
		return "Airline ID: " + airlineID+" Airline Name:"+airlineName;
	}
}


