package fms;

import java.util.ArrayList;

public class DurationSearchStrategy implements SearchFlightStrategy{
	public static DurationSearchStrategy instance=new DurationSearchStrategy();
	private DurationSearchStrategy() {
	}
	public static DurationSearchStrategy instance() {
		return instance;
	}
	@Override
	public ArrayList<Flight> searchFlight(ArrayList<Flight> flights ) {
		DurationComparator dc=new DurationComparator();
		flights.sort(dc);
		return flights;
	}
}
