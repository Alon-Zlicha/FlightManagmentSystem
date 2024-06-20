package fms;
import java.util.Comparator;

public class DurationComparator implements Comparator<Flight> {
	public DurationComparator() {
		
	}
	@Override
	public int compare(Flight f1,Flight f2) {
		if(f1.getDuration()<f2.getDuration()) {
			return -1;
		}
		return 1;
	}
}

