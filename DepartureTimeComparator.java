package fms;

import java.util.Comparator;

public class DepartureTimeComparator implements Comparator<Flight> {
	public DepartureTimeComparator() {
		
	}
	public int compare(Flight f1,Flight f2) {
		return f1.getDepartureTime().compareTo(f2.getDepartureTime());
	}
}

