package fms;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.Scanner;

public class FlightManagmentSystem {
	public static ArrayList<Flight> strategyPattern() {
		System.out.println("Enter 1 to search by price, 2 to search by duration or 3 to search by departure time");
		Scanner scanner=new Scanner(System.in);
		int a=scanner.nextInt();
		SearchFlightStrategy searcher=SearchStrategyFactory.select(a);
		StrategyContext sc=new StrategyContext(searcher);
		ArrayList<Flight> searchedList=sc.search(Flight.flightList);
		scanner.close();
		return searchedList;
	}
	public static void main(String[] args) {
		Airline elal=new Airline("1","El-Al");
		Airline elal1=new Airline("2","El-Al-1");
		Airline elal2=new Airline("3","El-Al-2");
		Airline elal2_1=new Airline("4","El-Al-2-1");
		elal.addSubAirline(elal1);
		elal.addSubAirline(elal2);
		elal2.addSubAirline(elal2_1);
		//print all the airline and the subAirlines details 
		System.out.println(elal);
		for (Airline subElal : elal.getSubAirlines()) {
	         System.out.println(subElal); 
	         for (Airline subSubElal : subElal.getSubAirlines()) {
	            System.out.println(subSubElal);
	         }
	    }	
		Airport bg=new Airport("Ben-Gurion");
		Airport lax=new Airport("LAX");
		LocalDateTime f1_depTime=LocalDateTime.of(2024,1,1,10,30);
		LocalDateTime f1_arrTime=LocalDateTime.of(2024,1,1,22,30);
		Flight f1=new Flight("1",bg,lax,f1_depTime,f1_arrTime,604,elal,499.99,500);
		Passenger az=new Passenger("1","Alon Zlicha","Alonz1414@gmail.com","0523973561");
		Employee mc=new Employee("2","Moshe Cohen","MosheCo12@elal.com");
		f1.addObserver(az);
		f1.addObserver(mc);
		LocalDateTime f2_depTime=LocalDateTime.of(2024,12,30,22,30);
		LocalDateTime f2_arrTime=LocalDateTime.of(2024,12,31,10,30);
		Flight f2=new Flight("2",lax,bg,f2_depTime,f2_arrTime,600,elal1,349.99,2);
		Passenger sl=new Passenger("3","Shimon Levi","shim1334@gmail.com","0543956561");
		Employee dk=new Employee("4","Dani Kushmaro","danikush44@elal_1.com");
		Passenger yl=new Passenger("5","Yonit Levi","yonitlev1212@gmail.com","0509845634");
		f2.addObserver(dk);
		f2.addObserver(sl);
		f2.addObserver(yl);
		System.out.println("The list of flight number 2 observers: ");
		f2.printFlightObservers();
		System.out.println("Ben Gurion departuring flights: ");
		bg.printDeparturingFlights();
		System.out.println("Ben Gurion arriving flights: ");
		bg.printArrivingFlights();
		System.out.println("LAX departuring flights: ");
		lax.printDeparturingFlights();
		System.out.println("LAX  arriving flights: ");
		lax.printArrivingFlights();
		System.out.println("The list of all flights:");
		for(int i=0;i<Flight.flightList.size();i++) {
			Flight.flightList.get(i).printFlight();
		}
		ArrayList<Flight> searchedList=strategyPattern();
        for (Flight flight : searchedList) {
            flight.printFlight();
        }
		f1.setStatus("canceled");
		f2.setStatus("delayed");
		f2.removeObserver(sl.getID());
		f2.addObserver(yl);
		for(int i=0;i<Flight.flightList.size();i++) {
			Flight.flightList.get(i).printFlight();
		}
		System.out.println("El-Al all flights:");
		ArrayList<Flight> elalFlights=elal.getAllFlights();
		for(Flight flight:elalFlights){
			flight.printFlight();
		}
		Flight.removeOldFlights();
		elalFlights = elal.getAllFlights();
		System.out.println("El-Al all flights after removing old flights:");
        for (Flight elalFlight : elalFlights) {
            elalFlight.printFlight();
        }
		System.out.println("Ben Gurion departuring flights after removing old flights: ");
		bg.printDeparturingFlights();
		System.out.println("LAX  arriving flights after removing old flights: ");
		lax.printArrivingFlights();
		elal.removeFlight(f1);
	}
}
