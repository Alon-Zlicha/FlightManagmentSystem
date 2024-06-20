package fms;

public class SearchStrategyFactory {
	public static SearchFlightStrategy select(int a) {
		if(a==1) {
			return PriceSearchStrategy.instance();
		}
		if(a==2) {
			return DurationSearchStrategy.instance();
		}
		if(a==3) {
			return DepartureTimeSearchStrategy.instance();
		}
		return null;
	}
}
