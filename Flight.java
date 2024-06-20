package fms;
import java.util.ArrayList;
import java.time.LocalDateTime;

public class Flight {
	private String flightNumber;
	private Airport origin;
	private Airport destination;
	private LocalDateTime departureTime;
	private LocalDateTime arrivalTime;
	private int duration;
	private Airline airline;
	private double price;
	private int capacity;
	private ArrayList<FlightObserver> flightObservers;
	private String status;
	public static ArrayList<Flight> flightList=new ArrayList<Flight>();;
	public Flight(String fn,Airport orig,Airport dst, LocalDateTime dt,LocalDateTime at,int dur,Airline airline,double pr,int c) {
		this.flightNumber=fn;
		this.origin=orig;
		orig.addDeparturingFlight(this);
		this.destination=dst;
		dst.addArrivingFlight(this);
		this.departureTime=dt;
		this.arrivalTime=at;
		this.duration=dur;
		this.airline=airline;
		airline.addFlight(this);
		this.price=pr;
	    this.capacity=c;
		this.status="on time";
		flightObservers=new ArrayList<FlightObserver>();
		flightList.add(this);
	}
	public String getFlightNumber() {
		return this.flightNumber;
	}
	public double getPrice() {
		return this.price;
	}
	public int getDuration() {
		return this.duration;
	}
	public LocalDateTime getDepartureTime() {
		return this.departureTime;
	}
	public LocalDateTime getArrivalTime(){return this.arrivalTime; }
	public void setStatus(String status) {
        this.status = status;
        notifyObservers();
    }
	private void notifyObservers() {
        for (Observer observer : flightObservers) {
            observer.update(status,this.flightNumber);
        }
    }
	public void addObserver(FlightObserver newObserver)  {
		if (flightObservers.size() >= capacity) {
            System.out.println("flight is full, cannot add observer");
            return;
        }
		flightObservers.add(newObserver);
	}
	public void removeObserver(String observerID) {
		int i=0;
        boolean found=false;
        while(i<flightObservers.size()&&!found) {
            FlightObserver observer=flightObservers.get(i);
            if (observer.getID().equals(observerID)) {
                flightObservers.remove(i);
                found = true;
            }
            i++;
        }
        if(!found) {
        	System.out.println("The ID is not in this flight");
        }
	}
	public ArrayList<FlightObserver> getFlightObservers(){
		return this.flightObservers;
	}
	public void printFlightObservers(){
        for (FlightObserver flightObserver : flightObservers) {
            System.out.println(flightObserver.toString());
        }
	}
	public void printFlight() {
		System.out.println(flightNumber+" "+origin.getName()+" "+destination.getName()+" "+departureTime+" "+arrivalTime.toString()+" duration-"+duration+" "+airline.getName()+" "+price+"$"+" seats left-"+(capacity-flightObservers.size())+" status-"+status);
	}
	public static void removeOldFlights(){
		for (int i=0;i<flightList.size();i++){
			if(flightList.get(i).getArrivalTime().isBefore(LocalDateTime.now())){
				flightList.get(i).airline.removeFlight(flightList.get(i));
				flightList.get(i).destination.removeArrivingFlight(flightList.get(i));
				flightList.get(i).origin.removeDeparturingFlight(flightList.get(i));
				flightList.remove(flightList.get(i));
			}
		}
	}
}
