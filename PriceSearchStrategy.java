package fms;

import java.util.ArrayList;
import java.util.Scanner;

public class PriceSearchStrategy implements SearchFlightStrategy {
	public static PriceSearchStrategy instance=new PriceSearchStrategy();
	private PriceSearchStrategy() {
	}
	public static PriceSearchStrategy instance() {
		return instance;
	}
	@Override
	public ArrayList<Flight> searchFlight(ArrayList<Flight> flights ) {
		ArrayList<Flight> byPrice=new ArrayList<Flight>();
		System.out.println("Enter maximum price");
		Scanner scanner=new Scanner(System.in);
		double max=scanner.nextDouble();
		for(int i=0;i<flights.size();i++) {
			if(flights.get(i).getPrice()<=max) {
				byPrice.add(flights.get(i));
			}
		}
		scanner.close();
		return byPrice;
	}
}
