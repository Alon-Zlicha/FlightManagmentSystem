package fms;

import java.util.ArrayList;

public class DepartureTimeSearchStrategy implements SearchFlightStrategy {
	public static DepartureTimeSearchStrategy instance=new DepartureTimeSearchStrategy();
	private DepartureTimeSearchStrategy() {
	}
	public static DepartureTimeSearchStrategy instance() {
		return instance;
	}
	public ArrayList<Flight> searchFlight(ArrayList<Flight> flights ) {
		DepartureTimeComparator dtc=new DepartureTimeComparator();
		flights.sort(dtc);
		return flights;
	}
}
