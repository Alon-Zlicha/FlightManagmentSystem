package fms;
import java.util.ArrayList;
public class StrategyContext{
	private SearchFlightStrategy strategy;
	public StrategyContext(SearchFlightStrategy strategy) {
		this.strategy=strategy;
	}
	public ArrayList<Flight> search(ArrayList<Flight> flights) {
		 ArrayList<Flight> searched=strategy.searchFlight(flights);
		 return searched;
	}
}
